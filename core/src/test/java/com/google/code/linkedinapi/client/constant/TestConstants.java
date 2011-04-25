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
package com.google.code.linkedinapi.client.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Nabeel Mukhtar
 *
 */
public final class TestConstants {

    /** Field description */
    public static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** Field description */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** Field description */
    public static final String LINKED_IN_TEST_CONSUMER_SECRET =
        testConstants.getProperty("com.google.code.linkedinapi.client.apiConsumerSecret");

    /** Field description */
    public static final String LINKED_IN_TEST_CONSUMER_KEY =
        testConstants.getProperty("com.google.code.linkedinapi.client.apiConsumerKey");

    /** Field description */
    public static final String LINKED_IN_TEST_ACCESS_TOKEN_SECRET =
        testConstants.getProperty("com.google.code.linkedinapi.client.accessTokenSecret");

    /** Field description */
    public static final String LINKED_IN_TEST_ACCESS_TOKEN_KEY =
        testConstants.getProperty("com.google.code.linkedinapi.client.accessTokenKey");

    /** Field description */
    public static final String LINKED_IN_TEST_EMAIL =
        testConstants.getProperty("com.google.code.linkedinapi.client.testEmail");

    /** Field description */
    public static final String LINKED_IN_TEST_ID =
        testConstants.getProperty("com.google.code.linkedinapi.client.testId");

    /** Field description */
    public static final String LINKED_IN_TEST_URL =
        testConstants.getProperty("com.google.code.linkedinapi.client.testUrl");

    /** Field description */
    public static final String LINKED_IN_TEST_SEARCH_PARAMS =
        testConstants.getProperty("com.google.code.linkedinapi.client.testSearchParameters");

    /** Field description */
    public static final String LINKED_IN_TEST_NETWORK_UPDATE_TEXT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testNetworkUpdateText");

    /** Field description */
    public static final String LINKED_IN_TEST_NETWORK_UPDATE_ID =
        testConstants.getProperty("com.google.code.linkedinapi.client.testNetworkUpdateId");

    /** Field description */
    public static final String LINKED_IN_TEST_NETWORK_UPDATE_COMMENT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testNetworkUpdateComment");

    /** Field description */
    public static final String LINKED_IN_TEST_STATUS_TEXT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testStatusText");

    /** Field description */
    public static final String LINKED_IN_TEST_MESSAGE_TEXT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testMessageText");

    /** Field description */
    public static final String LINKED_IN_TEST_MESSAGE_SUBJECT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testMessageSubject");

    /** Field description */
    public static final String LINKED_IN_TEST_MESSAGE_RECEPIENT_IDS =
        testConstants.getProperty("com.google.code.linkedinapi.client.testMessageRecepientIds");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_TEXT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteText");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_SUBJECT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteSubject");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_RECEPIENT_ID =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteRecepientId");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_FIRST_NAME =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteFirstName");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_LAST_NAME =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteLastName");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_EMAIL =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteEmail");

    /** Field description */
    public static final String LINKED_IN_TEST_INVITE_AUTH_HEADER =
        testConstants.getProperty("com.google.code.linkedinapi.client.testInviteAuthHeader");

    /** Field description */
    public static final String LINKED_IN_TEST_USER_NAME =
        testConstants.getProperty("com.google.code.linkedinapi.client.testUsername");

    /** Field description */
    public static final String LINKED_IN_TEST_PASSWORD =
        testConstants.getProperty("com.google.code.linkedinapi.client.testPassword");

    /** Field description */
    public static final String LINKED_IN_TEST_API_URL =
        testConstants.getProperty("com.google.code.linkedinapi.client.testApiUrl");

    /** Field description */
    public static final String LINKED_IN_TEST_CALLBACK_URL =
        testConstants.getProperty("com.google.code.linkedinapi.client.testCallbackUrl");

	public static final String LINKED_IN_TEST_SHARE_TEXT =
        testConstants.getProperty("com.google.code.linkedinapi.client.testShareText");

	public static final String LINKED_IN_TEST_SHARE_URL =
        testConstants.getProperty("com.google.code.linkedinapi.client.testShareUrl");
	
    /**
     * Constructs ...
     *
     */
    private TestConstants() {}
}
