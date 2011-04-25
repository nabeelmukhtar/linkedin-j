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
package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nabeel Mukhtar
 *
 */
public enum SearchSortOrder implements FieldEnum {
	
	
	/**
	 * Number of connections per person, from largest to smallest.
	 */
	CONNECTIONS("connections"),
	
    /**
     * Orders the returns by number of ensorsers each of the search returns has.
     */
    RECOMMENDERS("recommenders"),

    /**
     * Orders the returns based on the ascending degree of separation within a member's network, with first degree connections first.
     */
    DISTANCE("distance"),

    /**
     * Orders the returns based on relevance for the keywords provided.
     */
    RELEVANCE("relevance");
    
    /**
     * Field Description.
     */
	private static final Map<String, SearchSortOrder> stringToEnum = new HashMap<String, SearchSortOrder>();

	static { // Initialize map from constant name to enum constant
		for (SearchSortOrder op : values()) {
			stringToEnum.put(op.fieldName(), op);
		}
	}
	
    /** Field description */
    private final String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    SearchSortOrder(String name) {
        this.fieldName = name;
    }

    /**
     * @return the name of the field
     */
    public String fieldName() {
        return this.fieldName;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

	/**
	 *
	 * @return Returns SearchSortOrder for string, or null if string is invalid
	 */
	public static SearchSortOrder fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
