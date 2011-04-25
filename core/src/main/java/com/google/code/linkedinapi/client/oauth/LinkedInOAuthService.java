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

import java.net.HttpURLConnection;

import com.google.code.linkedinapi.client.LinkedInCommunicationClient;

/**
 * The Interface LinkedInOAuthService.
 * 
 * @author Nabeel Mukhtar
 */
public interface LinkedInOAuthService extends LinkedInCommunicationClient {

    /**
     * Gets the o auth request token.
     * 
     * @return the o auth request token
     */
    public LinkedInRequestToken getOAuthRequestToken();

    /**
     * Gets the o auth request token.
     * 
     * @param callBackUrl the callback url.
     * 
     * @return the o auth request token
     */
    public LinkedInRequestToken getOAuthRequestToken(String callBackUrl);
    
    /**
     * Gets the o auth access token.
     * 
     * @param requestToken the request token
     * @param oauthVerifier the oauthVerifier
     * 
     * @return the o auth access token
     */
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String oauthVerifier);

    /**
     * Sign request with token.
     * 
     * @param request the request
     * @param accessToken the access token
     */
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken);
    
    /**
     * Invalidate Token.
     * 
     * @param accessToken the access token
     */
    public void invalidateAccessToken(LinkedInAccessToken accessToken);
}
