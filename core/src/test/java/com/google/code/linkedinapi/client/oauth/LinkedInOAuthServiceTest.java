/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.oauth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.TestConstants;

/**
 * @author nmukhtar
 *
 */
public class LinkedInOAuthServiceTest extends TestCase {
	
    /** Field description */
    protected LinkedInOAuthService service;

	/** Field description */
	protected static final String RESOURCE_MISSING_MESSAGE = "Please define a test %s in TestConstants.properties file."; 

	/** Field description */
	protected static final Pattern OAUTH_VERIFIER_PATTERN = Pattern.compile("(.*)<div class=\"access-code\">(\\d+)</div>(.*)", Pattern.MULTILINE);
	
	/** Field description */
	protected static final Pattern CSRF_TOKEN_PATTERN = Pattern.compile("(.*)<input type=\"hidden\" name=\"csrfToken\" value=\"ajax\\:(\\d+)\" id=\"csrfToken-oauthAuthorizeForm\">(.*)", Pattern.MULTILINE);
	
	/** Field description */
	protected static final String LOGIN_URL = "https://api.linkedin.com/uas/oauth/authorize/submit";
	
    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Key"), TestConstants.LINKED_IN_TEST_CONSUMER_KEY);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Secret"), TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
		LinkedInOAuthServiceFactory factory = LinkedInOAuthServiceFactory.getInstance();
		service = factory.createLinkedInOAuthService(TestConstants.LINKED_IN_TEST_CONSUMER_KEY,
                TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		service = null;
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#getOAuthAccessToken(com.google.code.linkedinapi.client.oauth.LinkedInRequestToken, java.lang.String)}.
	 */
	@Test
	public void testGetOAuthAccessToken() {
		LinkedInRequestToken requestToken = service.getOAuthRequestToken();
		assertNotNull("Request token should not be null.", requestToken);
		assertNotNullOrEmpty("Token Key should not be null or empty.", requestToken.getToken());
		assertNotNullOrEmpty("Token Secret should not be null or empty.", requestToken.getTokenSecret());
		assertNotNullOrEmpty("Authorization url should not be null or empty.", requestToken.getAuthorizationUrl());
		String oauthVerifier = simulateWebLoginAndGetOauthVerifier(requestToken);
		assertNotNullOrEmpty("OAuth Verifier should not be null or empty.", oauthVerifier);
		LinkedInAccessToken accessToken = service.getOAuthAccessToken(requestToken, oauthVerifier);
		assertNotNull("Access token should not be null.", accessToken);
		assertNotNullOrEmpty("Access Token Key should not be null or empty.", accessToken.getToken());
		assertNotNullOrEmpty("Access Token Secret should not be null or empty.", accessToken.getTokenSecret());
		makeTestApiRequest(accessToken);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#getOAuthRequestToken()}.
	 */
	@Test
	public void testGetOAuthRequestToken() {
		LinkedInRequestToken requestToken = service.getOAuthRequestToken();
		assertNotNull("Request token should not be null.", requestToken);
		assertNotNullOrEmpty("Request Token Key should not be null or empty.", requestToken.getToken());
		assertNotNullOrEmpty("Request Token Secret should not be null or empty.", requestToken.getTokenSecret());
		assertNotNullOrEmpty("Authorization url should not be null or empty.", requestToken.getAuthorizationUrl());
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#getOAuthRequestToken(java.lang.String)}.
	 */
	@Test
	public void testGetOAuthRequestTokenString() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Callback URL"), TestConstants.LINKED_IN_TEST_CALLBACK_URL);
		LinkedInRequestToken requestToken = service.getOAuthRequestToken(TestConstants.LINKED_IN_TEST_CALLBACK_URL);
		assertNotNull("Request token should not be null.", requestToken);
		assertNotNullOrEmpty("Token Key should not be null or empty.", requestToken.getToken());
		assertNotNullOrEmpty("Token Secret should not be null or empty.", requestToken.getTokenSecret());
		assertNotNullOrEmpty("Authorization url should not be null or empty.", requestToken.getAuthorizationUrl());
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#signRequestWithToken(java.net.HttpURLConnection, com.google.code.linkedinapi.client.oauth.LinkedInAccessToken)}.
	 */
	@Test
	public void testSignRequestWithToken() {
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Access Token Key"), TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_KEY);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Access Token Secret"), TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_SECRET);
    	LinkedInAccessToken accessToken =
            new LinkedInAccessToken(TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_KEY,
                                    TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_SECRET);
		makeTestApiRequest(accessToken);
	}

	/**
	 * 
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
	
	/**
	 * Stolen liberally from http://www.kodejava.org/examples/266.html
	 */
	protected static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        return sb.toString();
    }
	
	private static String simulateWebLoginAndGetOauthVerifier(LinkedInRequestToken requestToken) {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Username"), TestConstants.LINKED_IN_TEST_USER_NAME);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Password"), TestConstants.LINKED_IN_TEST_PASSWORD);
		try {
			Map<String, String> parametersMap = getParametersMap(requestToken, TestConstants.LINKED_IN_TEST_USER_NAME, TestConstants.LINKED_IN_TEST_PASSWORD);
	        URL               url     = new URL(requestToken.getAuthorizationUrl());
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            if (request.getResponseCode() != 200) {
            	fail(convertStreamToString(request.getErrorStream()));
            }
            
            String tokenPage = convertStreamToString(request.getInputStream());
            
            Matcher m = CSRF_TOKEN_PATTERN.matcher(tokenPage);
            
            if (m.matches()) {
        		parametersMap.put("csrfToken", "ajax:" + m.group(2));
            }
            
            
            url     = new URL(LOGIN_URL);
            request = (HttpURLConnection) url.openConnection();
            request.setDoOutput(true);
            request.setRequestMethod("POST");
            // set post parameters
            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));

            out.print(getParametersString(parametersMap));
            out.flush();
            out.close();
            
            request.connect();
            if (request.getResponseCode() != 200) {
            	fail(convertStreamToString(request.getErrorStream()));
            }
            
            String verifierPage = convertStreamToString(request.getInputStream());
            
            m = OAUTH_VERIFIER_PATTERN.matcher(verifierPage);
            
            if (m.matches()) {
            	return m.group(2);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        	fail(e.getMessage());
        }
        
        return null;
	}
	
	private static String getParametersString(Map<String, String> parametersMap) {
		StringBuilder builder = new StringBuilder();
		Iterator<String> iter = parametersMap.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			builder.append(key);
			builder.append("=");
			try {
				builder.append(URLEncoder.encode(parametersMap.get(key), ApplicationConstants.CONTENT_ENCODING));
			} catch (Exception e) {
				builder.append(parametersMap.get(key));
			}
			if (iter.hasNext()) {
				builder.append("&");
			}
		}
		return builder.toString();
	}

	private static Map<String, String> getParametersMap(LinkedInRequestToken requestToken, String userName, String password) {
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("email", userName);
		parametersMap.put("password", password);
		parametersMap.put("duration", "24");
		parametersMap.put("authorize", "Grant Access");
		parametersMap.put("extra", "");
		parametersMap.put("access", "-3");
		parametersMap.put("agree", "true");
		parametersMap.put("oauth_token", requestToken.getToken());
		parametersMap.put("appId", "");
		parametersMap.put("sourceAlias", "uas-oauth-authorize");
		return parametersMap;
	}

	/**
	 * @param accessToken
	 */
	private void makeTestApiRequest(LinkedInAccessToken accessToken) {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "API URL"), TestConstants.LINKED_IN_TEST_API_URL);
		try {
	        URL               url     = new URL(TestConstants.LINKED_IN_TEST_API_URL);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	        
	        service.signRequestWithToken(request, accessToken);
            request.connect();

            if (request.getResponseCode() != 200) {
            	fail(convertStreamToString(request.getErrorStream()));
            }
        } catch (IOException e) {
        	e.printStackTrace();
        	fail(e.getMessage());
        }
	}
}
