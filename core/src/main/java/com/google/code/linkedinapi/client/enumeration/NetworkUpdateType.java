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
public enum NetworkUpdateType implements FieldEnum {

    /**
     * A connection has answered a question posed on LinkedIn Answers.
     */
    ANSWER_UPDATE("ANSW"),

    /**
     * An action that occurred in a partner application either by a connection or by an application itself. The contents of the update will be HTML entity encoded.
     */
    APPLICATION_UPDATE("APPS"),

    /**
     * These updates cover aspects of connections made on LinkedIn. They cover both the user connecting and the user's connections making connections (second degree connections).
     */
    CONNECTION_UPDATE("CONN"),

    /**
     * A connection has posted a job posting on LinkedIn
     */
    JOB_UPDATE("JOBS"),

    /**
     * A connection has joined a group.
     */
    GROUP_UPDATE("JGRP"),

    /**
     * A connection has updated their profile picture.
     */
    PICTURE_UPDATE("PICT"),

    /**
     * A connection has updated their extended profile, personal information such as phone number, IM account, and Twitter handle.
     */
    EXTENDED_PROFILE_UPDATE("PRFX"),
    
    /**
     * A connection was recommended
     */
    RECOMMENDATION_UPDATE("RECU"),

    /**
     * A connection has updated their profile. This does not include picture updates, which are covered under PICT type.
     */
    PROFILE_UPDATE("PRFU"),

    /**
     * A connection has asked a question on LinkedIn Answers.
     */
    QUESTION_UPDATE("QSTN"),

    /**
     * A connection has updated their status.
     * @deprecated Use {@link #SHARED_ITEM}
     */
    @Deprecated
    STATUS_UPDATE("STAT"), 
    
    /**
     * A connection has shared an update or link.
     */
    SHARED_ITEM("SHAR"),
    
    /**
     * A connection has commented on or liked another update.
     */
    VIRAL_UPDATE("VIRL"),
    
    /**
     * A change to one of the companies the member is following.
     */
    COMPANY_FOLLOW_UPDATE("CMPY");
    
    /**
     * Field Description.
     */
	private static final Map<String, NetworkUpdateType> stringToEnum = new HashMap<String, NetworkUpdateType>();

	static { // Initialize map from constant name to enum constant
		for (NetworkUpdateType op : values()) {
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
    NetworkUpdateType(String name) {
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
	 * @return Returns NetworkUpdateType for string, or null if string is invalid
	 */
	public static NetworkUpdateType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
