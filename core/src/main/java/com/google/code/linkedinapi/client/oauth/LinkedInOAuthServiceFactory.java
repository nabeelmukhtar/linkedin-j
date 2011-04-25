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


/**
 * A factory for creating LinkedInOAuthService objects.
 * 
 * @author Nabeel Mukhtar
 */
public class LinkedInOAuthServiceFactory {

    /** The instance. */
    private static LinkedInOAuthServiceFactory instance;

    /**
     * Instantiates a new linked in o auth service factory.
     */
    private LinkedInOAuthServiceFactory() {}

    /**
     * Gets the single instance of LinkedInOAuthServiceFactory.
     * 
     * @return single instance of LinkedInOAuthServiceFactory
     */
    public static synchronized LinkedInOAuthServiceFactory getInstance() {
        if (instance == null) {
            instance = new LinkedInOAuthServiceFactory();
        }

        return instance;
    }

    /**
     * Creates a new LinkedInOAuthService object.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the linked in o auth service
     */
    public LinkedInOAuthService createLinkedInOAuthService(String consumerKey, String consumerSecret) {
        return createLinkedInOAuthService(new LinkedInApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * Creates a new LinkedInOAuthService object.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the linked in o auth service
     */
    public LinkedInOAuthService createLinkedInOAuthService(LinkedInApiConsumer apiConsumer) {
    	validateConsumerKey(apiConsumer);
        return new LinkedInOAuthServiceImpl(apiConsumer);
    }
    
    /**
     * 
     */
	private void validateConsumerKey(LinkedInApiConsumer apiConsumer) {
		if (apiConsumer == null) {
    		throw new IllegalArgumentException("api consumer cannot be null.");
    	}
    	if (apiConsumer.getConsumerKey() == null || apiConsumer.getConsumerKey().length() == 0) {
    		throw new IllegalArgumentException("consumer key cannot be null or empty.");
    	}
    	if (apiConsumer.getConsumerSecret() == null || apiConsumer.getConsumerSecret().length() == 0) {
    		throw new IllegalArgumentException("consumer secret cannot be null or empty.");
    	}
	}
}
