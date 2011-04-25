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
package com.google.code.linkedinapi.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.google.code.linkedinapi.client.constant.LanguageCodes;
import com.google.code.linkedinapi.client.constant.RelationshipCodes;
import com.google.code.linkedinapi.client.constant.TestConstants;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.schema.FacetType;

/**
 * @author Nabeel Mukhtar
 *
 */
public abstract class LinkedInApiClientTest extends TestCase {

    /** Field description */
    protected LinkedInApiClientFactory factory;

    /** Field description */
    protected LinkedInAccessToken accessToken;
    
    /** Field description */
	protected static final String RESOURCE_MISSING_MESSAGE = "Please define a test %s in TestConstants.properties file."; 
    

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
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Key"), TestConstants.LINKED_IN_TEST_CONSUMER_KEY);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Secret"), TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
    	factory =
            LinkedInApiClientFactory.newInstance(TestConstants.LINKED_IN_TEST_CONSUMER_KEY,
                TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Access Token Key"), TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_KEY);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Access Token Secret"), TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_SECRET);
    	accessToken =
            new LinkedInAccessToken(TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_KEY,
                                    TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_SECRET);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    	factory = null;
    	accessToken = null;
    }
    
	/**
	 * 
	 */
	protected Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 
	 */
	protected Date getLastWeekDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -7);
		return calendar.getTime();
	}

	/**
	 * 
	 */
	protected Map<SearchParameter, String> getSearchParametersMap(String searchParameters) {
		Map<SearchParameter, String> map = new EnumMap<SearchParameter, String>(SearchParameter.class);
		String[] entries = searchParameters.split(",");
		for (String entry : entries) {
			String[] tuple = entry.split("=");
			if (tuple.length == 2) {
				map.put(SearchParameter.fromString(tuple[0]), tuple[1]);
			}
						
		}
		return map;
	}

	/**
	 * 
	 */
	protected List<String> getRecepientIdsList(String messageRecepients) {
		return Arrays.asList(messageRecepients.split(","));
	}
	
	/**
	 * 
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
	
	/**
	 * 
	 */
	protected List<Parameter<FacetType, String>> getTestFacets() {
		List<Parameter<FacetType, String>> facets = new ArrayList<Parameter<FacetType,String>>();
		facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.OUT_OF_NETWORK_CONNECTIONS));
		facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.SECOND_DEGREE_CONNECTIONS));
		facets.add(new Parameter<FacetType, String>(FacetType.LANGUAGE, LanguageCodes.ENGLISH));
		return facets;
	}
}
