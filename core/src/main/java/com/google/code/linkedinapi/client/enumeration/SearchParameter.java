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
public enum SearchParameter implements FieldEnum {

    /**
     * Returns members who have keywords anywhere in their profile. Multiple words should be separated by a plus (+) sign. Boolean logic isn't supported in this parameter.
     */
    KEYWORDS("keywords"),

    /**
     * Members with a matching first name. Matches must be exact. Multiple words should be separated by a space.
     */
    FIRST_NAME("first-name"),
    
    /**
     * Members with a matching last name. Matches must be exactly. Multiple words should be separated by a space.
     */
    LAST_NAME("last-name"),    

    /**
     * Returns members who have a particular company name on their profile. company works with the current-company parameter which specifies whether the company must be a current company or whether it can be anywhere on a profile.
     */
    COMPANY_NAME("company-name"),

    /**
     * Valid values are true or false.
     */
    CURRENT_COMPANY("current-company"),

    /**
     * Returns members who have a particular title on their profile
     */
    TITLE("title"),

    /**
     * Valid values are true or false.
     */
    CURRENT_TITLE("current-title"),

    /**
     * Members who have a matching school name on their profile.
     */
    SCHOOL_NAME("school-name"),

    /**
     * Valid values are true or false. A value of true matches members who currently attend the school specified in the school-name parameter.
     */
    CURRENT_SCHOOL("current-school"),
    
    /**
     * Returns members within a specific country.
     */
    COUNTRY_CODE("country-code"),

    /**
     * Returns members within a specific postal code.
     */
    POSTAL_CODE("postal-code"),

    /**
     * Matches members within a distance from a central point. This is measured in miles.
     */
    DISTANCE("distance"),
    
    /**
     * Facet values to search over.
     */
    FACET("facet"),
    
    /**
     * Facet buckets to return.
     */
    FACETS("facets");
    
    /**
     * Field Description.
     */
	private static final Map<String, SearchParameter> stringToEnum = new HashMap<String, SearchParameter>();

	static { // Initialize map from constant name to enum constant
		for (SearchParameter op : values()) {
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
    SearchParameter(String name) {
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
	 * @return Returns SearchParameter for string, or null if string is invalid
	 */
	public static SearchParameter fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
