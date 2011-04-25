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
public enum FacetField implements CompositeEnum<FacetField> {

    /**
     * A human readable name for the facet.
     */
	NAME("name", null),

    /**
     * The machine processable value for the facet.
     */
	CODE("code", null),

    /**
     * The facet bucket values for the facet.
     */
	BUCKETS("buckets", null),

    /**
     * A human readable name for the facet bucket.
     */
	BUCKET_NAME("name", BUCKETS),

    /**
     * The machine processable value for the bucket.
     */
	BUCKET_CODE("code", BUCKETS),

    /**
     * The number of results inside the bucket.
     */
	BUCKET_COUNT("count", BUCKETS),

	/**
     * If this bucket's results are included in your search query.
     */
	BUCKET_SELECTED("selected", BUCKETS);
    
    /**
     * Field Description.
     */
	private static final Map<String, FacetField> stringToEnum = new HashMap<String, FacetField>();

	static { // Initialize map from constant name to enum constant
		for (FacetField op : values()) {
			stringToEnum.put(op.fieldName(), op);
		}
	}

    /** Field description */
    private final String fieldName;

    /** Field description */
    private final FacetField parent;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    FacetField(String name, FacetField parent) {
        this.fieldName = name;
        this.parent = parent;
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
	 * @return Returns ProfileType for string, or null if string is invalid
	 */
	public static FacetField fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

	@Override
	public FacetField parent() {
		return parent;
	}
}
