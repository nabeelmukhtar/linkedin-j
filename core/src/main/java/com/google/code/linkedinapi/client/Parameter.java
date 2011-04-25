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
package com.google.code.linkedinapi.client;

/**
 * The Class Parameter.
 * 
 * @author nmukhtar
 */
public class Parameter<Name, Value> {
	
	/** The name. */
	private Name name;
	
	/** The value. */
	private Value value;
	
	/**
	 * Instantiates a new parameter.
	 * 
	 * @param name the name
	 * @param value the value
	 */
	public Parameter(Name name, Value value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 * 
	 * @param value the value to set
	 */
	public void setValue(Value value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Parameter<Name, Value> other = (Parameter<Name, Value>) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
