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
public enum PositionsField implements FieldEnum {

    /**
     * a unique identifier for this member's position.
     */
    ID("id"),

    /**
     * the job title held at the position, as indicated by the member
     */
    TITLE("title"),

    /**
     * a summary of the member's position
     */
    SUMMARY("summary"),

    /**
     * a structured object with month and year fields indicating when the position began
     */
    START_DATE("start-date"),

    /**
     * a structured object with month and year fields indicating when the position ended.
     */
    END_DATE("end-date"),

    /**
     * a "true" or "false" value, depending on whether it is marked current
     */
    IS_CURRENT("is-current"),

    /**
     * The name of the company the member works for
     */
    COMPANY_BANE("company/name");
    
    /**
     * Field Description.
     */
	private static final Map<String, PositionsField> stringToEnum = new HashMap<String, PositionsField>();

	static { // Initialize map from constant name to enum constant
		for (PositionsField op : values()) {
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
    PositionsField(String name) {
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
	 * @return Returns PositionsField for string, or null if string is invalid
	 */
	public static PositionsField fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
