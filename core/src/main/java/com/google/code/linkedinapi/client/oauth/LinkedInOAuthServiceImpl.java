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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.signature.AuthorizationHeaderSigningStrategy;
import oauth.signpost.signature.HmacSha1MessageSigner;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls;

/**
 * @author Nabeel Mukhtar
 *
 */
class LinkedInOAuthServiceImpl implements LinkedInOAuthService {

    /** Field description */
    private final LinkedInApiConsumer apiConsumer;

    /** Field description */
    private Map<String, String> requestHeaders;
    
    /** Field description */
    private static final String OAUTH_VERSION_1_0_a = "1.0a";
    
    /**
     * Constructs ...
     *
     *
     * @param apiConsumer
     */
    LinkedInOAuthServiceImpl(LinkedInApiConsumer apiConsumer) {
    	requestHeaders = new HashMap<String, String>();
    	this.apiConsumer = apiConsumer;
    }
    
    /**
     * Sets the request headers.
     *
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	if (requestHeaders == null) {
    		throw new IllegalArgumentException("request headers cannot be null.");
    	}
        this.requestHeaders = requestHeaders;
    }

    /**
     * Gets the request headers.
     *
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * Adds the request header.
     *
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /**
     * Removes the request header.
     *
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }
    
    @Override
    public void addLocale(Locale locale) {
    	// TODO Auto-generated method stub
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String oauthVerifier) {
    	if (requestToken == null) {
    		throw new IllegalArgumentException("request token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
        	consumer.setTokenWithSecret(requestToken.getToken(), requestToken.getTokenSecret());
            provider.retrieveAccessToken(consumer, oauthVerifier);

            LinkedInAccessToken accessToken = new LinkedInAccessToken(consumer.getToken(), consumer.getTokenSecret());
            
            SortedSet<String> responseParameters = provider.getResponseParameters().get(ApplicationConstants.EXPIRATION_PARAMETER_NAME);
            setTokenExpirationTime(accessToken, responseParameters);
            
            return accessToken;
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInRequestToken getOAuthRequestToken() {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
            String               authorizationUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
            LinkedInRequestToken requestToken     = new LinkedInRequestToken(consumer.getToken(),
                                                        consumer.getTokenSecret());

            requestToken.setAuthorizationUrl(authorizationUrl);
            
            SortedSet<String> responseParameters = provider.getResponseParameters().get(ApplicationConstants.EXPIRATION_PARAMETER_NAME);
            setTokenExpirationTime(requestToken, responseParameters);

            return requestToken;
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInRequestToken getOAuthRequestToken(String callBackUrl) {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
            String               authorizationUrl = provider.retrieveRequestToken(consumer, callBackUrl);
            LinkedInRequestToken requestToken     = new LinkedInRequestToken(consumer.getToken(),
                                                        consumer.getTokenSecret());

            requestToken.setAuthorizationUrl(authorizationUrl);

            return requestToken;
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken) {
    	if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
            consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());
            consumer.sign(request);
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }
    
    /**
     * {@inheritDoc}
     */
	@Override
	public void invalidateAccessToken(LinkedInAccessToken accessToken) {
    	if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
        try {
            URL               url     = new URL(LinkedInApiUrls.LINKED_IN_OAUTH_INVALIDATE_TOKEN_URL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
        	
        	final OAuthConsumer consumer = getOAuthConsumer();
            consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());
            consumer.sign(request);
            request.connect();

            if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	throw new LinkedInOAuthServiceException(convertStreamToString(request.getErrorStream()));
            }
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
	}
    
    /** 
     *
     */
    protected OAuthProvider getOAuthProvider() {
    	DefaultOAuthProvider provider = new DefaultOAuthProvider(LinkedInApiUrls.LINKED_IN_OAUTH_REQUEST_TOKEN_URL,
		        LinkedInApiUrls.LINKED_IN_OAUTH_ACCESS_TOKEN_URL, LinkedInApiUrls.LINKED_IN_OAUTH_AUTHORIZE_URL);
    	
    	provider.setOAuth10a(OAUTH_VERSION_1_0_a.equals(ApplicationConstants.OAUTH_VERSION));
    	
        for (String headerName : requestHeaders.keySet()) {
        	provider.setRequestHeader(headerName, requestHeaders.get(headerName));
        }
    	
    	return provider;
	}

    /** 
    *
    */
	protected OAuthConsumer getOAuthConsumer() {
		DefaultOAuthConsumer consumer = new DefaultOAuthConsumer(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());
		consumer.setMessageSigner(new HmacSha1MessageSigner());
		consumer.setSigningStrategy(new AuthorizationHeaderSigningStrategy());
		return consumer;
	}
	
	/**
	 * @param token
	 * @param responseParameters
	 */
	protected void setTokenExpirationTime(LinkedInOAuthToken token,
			SortedSet<String> responseParameters) {
		if (responseParameters != null && !responseParameters.isEmpty()) {
			Calendar calendar = Calendar.getInstance();
			int secondsToLive = Integer.valueOf(responseParameters.first());
			calendar.add(Calendar.SECOND, secondsToLive);
			token.setExpirationTime(calendar.getTime());
		}
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
}
