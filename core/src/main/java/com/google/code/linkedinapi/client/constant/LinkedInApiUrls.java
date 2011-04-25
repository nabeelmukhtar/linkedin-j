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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.enumeration.CompositeEnum;
import com.google.code.linkedinapi.client.enumeration.FieldEnum;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.FacetType;

/**
 * The Class LinkedInApiUrls.
 */
public final class LinkedInApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "LinkedInApiUrls.properties";

    /** The static logger. */
    private static final Logger LOG = Logger.getLogger(LinkedInApiUrls.class.getCanonicalName());
    
    /** The Constant linkedInApiUrls. */
    private static final Properties linkedInApiUrls = new Properties();

    static {
        try {
            linkedInApiUrls.load(LinkedInApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }

    /** The Constant GET_PROFILE_FOR_CURRENT_USER. */
    public static final String GET_PROFILE_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileForCurrentUser");

    /** The Constant GET_PROFILE_BY_ID. */
    public static final String GET_PROFILE_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileById");

    /** The Constant GET_PROFILE_BY_URL. */
    public static final String GET_PROFILE_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileByUrl");

    /** The Constant SEARCH_PEOPLE. */
    public static final String SEARCH_PEOPLE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.searchPeople");

    /** The Constant SEARCH_PEOPLE. */
    public static final String SEARCH_FACETS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.searchFacets");
    
    /** The Constant SEARCH_PEOPLE_FACETS. */
    public static final String SEARCH_PEOPLE_FACETS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.searchPeopleFacets");
    
    /** The Constant POST_UPDATE. */
    public static final String POST_UPDATE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postUpdate");

    /** The Constant POST_STATUS. */
    public static final String POST_STATUS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postStatus");

    /** The Constant POST_COMMENT. */
    public static final String POST_COMMENT =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postComment");

    /** The Constant SEND_MESSAGE. */
    public static final String SEND_MESSAGE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.sendMessage");


    /** The Constant LINKED_IN_OAUTH_REQUEST_TOKEN_URL. */
    public static final String LINKED_IN_OAUTH_REQUEST_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.requestToken");

    /** The Constant LINKED_IN_OAUTH_AUTHORIZE_URL. */
    public static final String LINKED_IN_OAUTH_AUTHORIZE_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.authorize");

    /** The Constant LINKED_IN_OAUTH_ACCESS_TOKEN_URL. */
    public static final String LINKED_IN_OAUTH_ACCESS_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.accessToken");

    /** The Constant LINKED_IN_OAUTH_ACCESS_TOKEN_URL. */
    public static final String LINKED_IN_OAUTH_INVALIDATE_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.invalidateToken");
    
    /** The Constant NETWORK_UPDATES. */
    public static final String NETWORK_UPDATES =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdates");
    
    /** The Constant USER_UPDATES. */
    public static final String USER_UPDATES =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.userUpdates");
    
    /** The Constant NETWORK_UPDATE_COMMENTS. */
    public static final String NETWORK_UPDATE_COMMENTS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdateComments");
    
    /** The Constant NETWORK_UPDATE_LIKES. */
    public static final String NETWORK_UPDATE_LIKES =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdateLikes");
    
    /** The Constant NETWORK_UPDATE_LIKE. */
    public static final String NETWORK_UPDATE_LIKE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdateLike");
    
    /** The Constant GET_CONNECTIONS_FOR_CURRENT_USER. */
    public static final String GET_CONNECTIONS_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsForCurrentUser");

    /** The Constant GET_CONNECTIONS_BY_ID. */
    public static final String GET_CONNECTIONS_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsById");

    /** The Constant GET_CONNECTIONS_BY_EMAIL. */
    public static final String GET_CONNECTIONS_BY_EMAIL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByEmail");

    /** The Constant GET_CONNECTIONS_BY_URL. */
    public static final String GET_CONNECTIONS_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByUrl");

    /** The Constant SEND_MESSAGE_PERSON_PATH. */
    public static final String SEND_MESSAGE_PERSON_PATH =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.messagePersonPath");

    /** The Constant SEND_INVITE_ID_PERSON_PATH. */
    public static final String SEND_INVITE_ID_PERSON_PATH =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.inviteIdPersonPath");

    /** The Constant SEND_INVITE_EMAIL_PERSON_PATH. */
    public static final String SEND_INVITE_EMAIL_PERSON_PATH =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.inviteEmailPersonPath");
    
    /** The Constant POST_SHARE. */
    public static final String POST_SHARE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postShare");
    
    /** The Constant RE_SHARE. */
    public static final String RE_SHARE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.reShare");
    
    /**
     * Instantiates a new linked in api urls.
     */
    private LinkedInApiUrls() {}

    /**
     * The Class LinkedInApiUrlBuilder.
     */
    public static class LinkedInApiUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
        /** The Constant QUERY_PARAMETERS_PLACEHOLDER. */
        private static final String QUERY_PARAMETERS_PLACEHOLDER = "queryParameters";
    	
    	/** The url format. */
	    private String urlFormat;
    	
	    /** The url type. */
	    @SuppressWarnings("unused")
		private String urlType;
    	
    	/** The parameters map. */
	    private Map<String, Collection<String>> parametersMap = new HashMap<String, Collection<String>>();
    	
	    /** The fields map. */
	    private Map<String, String> fieldsMap = new HashMap<String, String>();
    	
    	/**
	     * Instantiates a new linked in api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public LinkedInApiUrlBuilder(String urlFormat) {
    		this.urlFormat = urlFormat;    		
    	}
    	
    	/**
	     * Instantiates a new linked in api url builder.
	     * 
	     * @param urlFormat the url format
	     * @param urlType the url type
	     */
	    public LinkedInApiUrlBuilder(String urlFormat, String urlType) {
    		this.urlFormat = urlFormat;
    		this.urlType = urlType;
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		parametersMap.put(name, Collections.singleton(encodeUrl(value)));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameters.
	     * 
	     * @param name the name
	     * @param values the values
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withParameters(String name, Collection<String> values) {
	    	List<String> encodedValues = new ArrayList<String>(values.size());
	    	for (String value : values) {
	    		encodedValues.add(encodeUrl(value));
	    	}
    		parametersMap.put(name, encodedValues);
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withParameterEnumSet(String name, Set<? extends FieldEnum> enumSet) {
	    	Set<String> values = new HashSet<String>(enumSet.size());
	    	
	    	for (FieldEnum fieldEnum : enumSet) {
	    		values.add(encodeUrl(fieldEnum.fieldName()));
	    	}
	    	
    		parametersMap.put(name, values);
    		
    		return this;
    	}
	    
    	/**
	     * With parameter enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withParameterEnum(String name, FieldEnum value) {
	    	withParameter(name, value.fieldName());
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum map.
	     * 
	     * @param enumMap the enum map
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withParameterEnumMap(Map<? extends FieldEnum, String> enumMap) {
	    	for (FieldEnum parameter : enumMap.keySet()) {
	    		withParameter(parameter.fieldName(), enumMap.get(parameter));
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With empty field.
	     * 
	     * @param name the name
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withEmptyField(String name) {
    		fieldsMap.put(name, "");
    		
    		return this;
    	}
	    
    	/**
	     * With field.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withField(String name, String value) {
	    	withField(name, value, false);
    		
    		return this;
    	}
	    
    	/**
	     * With field.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withField(String name, String value, boolean escape) {
	    	if (escape) {
	    		fieldsMap.put(name, encodeUrl(value));
	    	} else {
	    		fieldsMap.put(name, value);
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With field enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withFieldEnum(String name, FieldEnum value) {
	    	if (value.fieldName() == null || value.fieldName().length() == 0) {
	    		fieldsMap.put(name, "");
	    	} else {
	    		fieldsMap.put(name, ":" + value.fieldName());
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With field enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the linked in api url builder
	     */
	    public LinkedInApiUrlBuilder withFieldEnumSet(String name, Set<? extends CompositeEnum<?>> enumSet) {
	    	StringBuilder builder = new StringBuilder();
	    	if (!enumSet.isEmpty()) {
	    		Map<? extends CompositeEnum<?>, Set<CompositeEnum<?>>> enumMap = convertIntoEnumMap(enumSet);
				builder.append(":");
				builder.append("(");
	    		Set<CompositeEnum<?>> orphanFields = enumMap.remove(null);
	    		if (orphanFields != null) {
	    			orphanFields.removeAll(enumMap.keySet());
					appendChildEnums(builder, orphanFields);
	    		}
	    		if (orphanFields != null && !orphanFields.isEmpty() && !enumMap.isEmpty()) {
		    		builder.append(",");
	    		}
	    		if (!enumMap.isEmpty()) {
		    		Iterator<? extends CompositeEnum<?>> parentIter = enumMap.keySet().iterator();
		    		while (parentIter.hasNext()) {
		    			CompositeEnum<?> parent = parentIter.next();
		    			Set<? extends CompositeEnum<?>> childEnums = enumMap.get(parent);
		    			if (!enumMap.containsKey(parent.parent())) {
		    				builder.append(parent.fieldName());
		    				builder.append(":");
		    				builder.append("(");
				        	appendChildEnums(builder, childEnums, enumMap);
							builder.append(")");
				        	if (parentIter.hasNext()) {
			    				builder.append(",");
				        	}
		    			}
		    		}
	    		}
				builder.append(")");
	    	}
    		
    		fieldsMap.put(name, builder.toString());
    		
    		return this;
    	}

		private void appendChildEnums(StringBuilder builder,
				Set<? extends CompositeEnum<?>> childEnums,
				Map<? extends CompositeEnum<?>, Set<CompositeEnum<?>>> enumMap) {
			Iterator<? extends CompositeEnum<?>> childIter = childEnums.iterator();
			while (childIter.hasNext()) {
				CompositeEnum<?> fieldEnum = childIter.next();
				builder.append(fieldEnum.fieldName());
				if (enumMap.containsKey(fieldEnum)) {
    				builder.append(":");
    				builder.append("(");
		        	appendChildEnums(builder, enumMap.get(fieldEnum), enumMap);
					builder.append(")");
				} 
				if (childIter.hasNext()) {
					builder.append(",");
				}
			}
		}

		/**
		 * @param builder
		 * @param childEnums
		 */
		private void appendChildEnums(StringBuilder builder,
				Set<? extends CompositeEnum<?>> childEnums) {
			Iterator<? extends CompositeEnum<?>> childIter = childEnums.iterator();
			while (childIter.hasNext()) {
				CompositeEnum<?> fieldEnum = childIter.next();
				builder.append(fieldEnum.fieldName());
				if (childIter.hasNext()) {
					builder.append(",");
				}
			}
		}
	    
	    private Map<? extends CompositeEnum<?>, Set<CompositeEnum<?>>> convertIntoEnumMap(
				Set<? extends CompositeEnum<?>> enumSet) {
	    	Map<CompositeEnum<?>, Set<CompositeEnum<?>>> enumMap = new HashMap<CompositeEnum<?>, Set<CompositeEnum<?>>>();
	    	for (CompositeEnum<?> e : enumSet) {
	    		while (e != null) {
		    		Set<CompositeEnum<?>> childEnums = enumMap.get(e.parent());
		    		if (childEnums == null) {
		    			childEnums = new HashSet<CompositeEnum<?>>();
		    			enumMap.put(e.parent(), childEnums);
		    		}
		    		childEnums.add(e);
		    		e = e.parent();
	    		}
	    	}
			return enumMap;
		}

		public LinkedInApiUrlBuilder withFacets(List<Parameter<FacetType, String>> facets) {
	    	Map<FacetType, List<String>> facetsMap = new HashMap<FacetType, List<String>>();
	    	for (Parameter<FacetType, String> facet : facets) {
	    		List<String> lstFacets = facetsMap.get(facet.getName());
	    		if (lstFacets == null) {
	    			lstFacets = new ArrayList<String>();
	    			facetsMap.put(facet.getName(), lstFacets);
	    		}
	    		lstFacets.add(facet.getValue());    		
	    	}
	    	List<String> facetParamValues = new ArrayList<String>();
	    	for (Map.Entry<FacetType, List<String>> entry : facetsMap.entrySet()) {
	    		StringBuilder buffer = new StringBuilder();
	    		buffer.append(entry.getKey().value());
	    		for (String facetValue: entry.getValue()) {
	    			buffer.append(",");
	    			buffer.append(facetValue);
	    		}
	    		facetParamValues.add(buffer.toString());
	    	}
			return withParameters(SearchParameter.FACET.fieldName(), facetParamValues);
	    }
	    
    	/**
	     * Builds the url.
	     * 
	     * @return the string
	     */
		public String buildUrl() {
        	StringBuilder urlBuilder = new StringBuilder();
        	StringBuilder placeHolderBuilder = new StringBuilder();
        	boolean placeHolderFlag = false;
        	for (int i = 0; i < urlFormat.length(); i++) {
        		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
        			placeHolderBuilder = new StringBuilder();
        			placeHolderFlag = true;
        		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
        			String placeHolder = placeHolderBuilder.toString();
        			if (fieldsMap.containsKey(placeHolder)) {
        				urlBuilder.append(fieldsMap.get(placeHolder));
        			} else if (QUERY_PARAMETERS_PLACEHOLDER.equals(placeHolder)) {
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parametersMap.isEmpty()) {
    			        	builder.append("?");
    			    		Iterator<String> iter = parametersMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
			    				Collection<String> parameterValues = parametersMap.get(name);
			    				Iterator<String> iterParam = parameterValues.iterator();
			    				while (iterParam.hasNext()) {
    			    				builder.append(name);
    			    				builder.append("=");
    			    				builder.append(iterParam.next());
    			    				if (iterParam.hasNext()) {
        			    				builder.append("&");
    			    				}
			    				}
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
        			} else {
        				// we did not find a binding for the placeholder.
        				// append it as it is.
        				urlBuilder.append(API_URLS_PLACEHOLDER_START);
        				urlBuilder.append(placeHolder);
        				urlBuilder.append(API_URLS_PLACEHOLDER_END);
        			}
        			placeHolderFlag = false;
        		} else if (placeHolderFlag) {
        			placeHolderBuilder.append(urlFormat.charAt(i));
        		} else {
        			urlBuilder.append(urlFormat.charAt(i));
        		}
        	}

        	return urlBuilder.toString();
    	}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * @param encoding the encoding
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
