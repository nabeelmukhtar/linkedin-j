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

import java.io.Serializable;
import java.util.Date;

/**
 * Class description
 *
 *
 */
public abstract class LinkedInOAuthToken implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4249791194912997698L;
	
    /** Access Token */
    private String token;

    /** Token Secret */
    private String tokenSecret;
    
    /** Token Secret */
    private Date expirationTime;

    /**
     * Constructs ...
     *
     *
     * @param token token
     * @param tokenSecret token secret
     */
    public LinkedInOAuthToken(String token, String tokenSecret) {
        this.token       = token;
        this.tokenSecret = tokenSecret;
    }

    /**
    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;

        result = prime * result + ((token == null)
                                   ? 0
                                   : token.hashCode());
        result = prime * result + ((tokenSecret == null)
                                   ? 0
                                   : tokenSecret.hashCode());

        return result;
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final LinkedInOAuthToken other = (LinkedInOAuthToken) obj;

        if (token == null) {
            if (other.token != null) {
                return false;
            }
        } else if (!token.equals(other.token)) {
            return false;
        }

        if (tokenSecret == null) {
            if (other.tokenSecret != null) {
                return false;
            }
        } else if (!tokenSecret.equals(other.tokenSecret)) {
            return false;
        }

        return true;
    }

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the tokenSecret
	 */
	public String getTokenSecret() {
		return tokenSecret;
	}

	/**
	 * @param tokenSecret the tokenSecret to set
	 */
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	/**
	 * @return the expirationTime
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}

	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
}
