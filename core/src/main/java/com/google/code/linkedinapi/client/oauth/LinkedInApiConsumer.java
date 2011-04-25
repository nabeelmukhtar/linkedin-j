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
 * Class description
 *
 *
 */
public class LinkedInApiConsumer extends LinkedInOAuthToken {

    /**
	 * 
	 */
	private static final long serialVersionUID = -508151196474695320L;

	/**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }
    
    /**
     * {@see LinkedInOAuthToken#getToken()}
     */
    public String getConsumerKey() {
        return getToken();
    }

    /**
     * {@see LinkedInOAuthToken#setToken()}
     */
    public void setConsumerKey(String consumerKey) {
        setToken(consumerKey);
    }

    /**
     * {@see LinkedInOAuthToken#getTokenSecret()}
     */
    public String getConsumerSecret() {
        return getTokenSecret();
    }

    /**
     * {@see LinkedInOAuthToken#setTokenSecret()}
     */
    public void setConsumerSecret(String consumerSecret) {
        setTokenSecret(consumerSecret);
    }
}
