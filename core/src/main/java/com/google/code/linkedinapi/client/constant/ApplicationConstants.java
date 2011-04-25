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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class ApplicationConstants.
 *
 * @author Nabeel Mukhtar
 */
public final class ApplicationConstants {

    /** The Constant APP_CONSTANTS_FILE. */
    public static final String APP_CONSTANTS_FILE = "ApplicationConstants.properties";

    /** The static logger. */
    private static final Logger LOG = Logger.getLogger(ApplicationConstants.class.getCanonicalName());
    
    /** The Constant applicationConstants. */
    private static final Properties applicationConstants = new Properties();

    static {
        try {
            applicationConstants.load(
                ApplicationConstants.class.getResourceAsStream(APP_CONSTANTS_FILE));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "An error occurred while loading properties.", e);
        }
    }

    /** The Constant VALIDATE_XML. */
    public static final boolean VALIDATE_XML = getBooleanProperty("com.google.code.linkedinapi.client.validateXml");

    /** The Constant OAUTH_VERSION. */
    public static final String OAUTH_VERSION = getProperty("com.google.code.linkedinapi.client.oauthVersion");

    /** The Constant DEFAULT_RESULT_SIZE. */
    public static final int DEFAULT_RESULT_SIZE =
        getIntProperty("com.google.code.linkedinapi.client.defaultResultSize");

    /** The Constant CONTENT_TYPE_XML. */
    public static final String CONTENT_TYPE_XML = getProperty("com.google.code.linkedinapi.client.contentTypeXml");

    /** The Constant CONTENT_ENCODING. */
    public static final String CONTENT_ENCODING = getProperty("com.google.code.linkedinapi.client.encoding");

    /** The Constant CLIENT_DEFAULT_IMPL. */
    public static final String CLIENT_DEFAULT_IMPL = getProperty("com.google.code.linkedinapi.client.defaultImpl");

    /** The Constant CONNECT_TIMEOUT. */
    public static final int CONNECT_TIMEOUT = getIntProperty("com.google.code.linkedinapi.client.connectTimeout");
    
    /** The Constant READ_TIMEOUT. */
    public static final int READ_TIMEOUT = getIntProperty("com.google.code.linkedinapi.client.readTimeout");
    
    /** The Constant AUTH_HEADER_NAME. */
    public static final String AUTH_HEADER_NAME = getProperty("com.google.code.linkedinapi.client.authHeaderName");
    
    /** The Constant FORMAT_HEADER_NAME. */
    public static final String FORMAT_HEADER_NAME = getProperty("com.google.code.linkedinapi.client.formatHeaderName");
    
    /** The Constant AUTH_HEADER_NAME. */
    public static final String EXPIRATION_PARAMETER_NAME = getProperty("com.google.code.linkedinapi.client.expirationParameterName");
    
    /**
     * Instantiates a new application constants.
     */
    private ApplicationConstants() {}

    /**
     * Get property as int.
     */
    public static String getProperty(String key) {
        return applicationConstants.getProperty(key);
    }

    /**
     * Get property as int.
     */
    public static int getIntProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Integer.parseInt(property);
        }
    }

    /**
     * Get property as boolean.
     */
    public static boolean getBooleanProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return false;
        } else {
            return Boolean.parseBoolean(property);
        }
    }

    /**
     * Get property as double.
     */
    public static double getDoubleProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Double.parseDouble(property);
        }
    }

    /**
     * Get property as long.
     */
    public static long getLongProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Long.parseLong(property);
        }
    }

    /**
     * Get property as long.
     */
    private static boolean isNullOrEmpty(String s) {
        return ((s == null) || s.length() == 0);
    }
}
