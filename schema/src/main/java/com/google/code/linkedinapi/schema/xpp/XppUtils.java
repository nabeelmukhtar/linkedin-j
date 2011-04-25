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
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/**
 * The Class DomUtils.
 * 
 * @author    Nabeel Mukhtar
 * @version   1.0
 */
public class XppUtils {

    /**
     * Sets the element value to node.
     * 
     * @param node the node
     * @param elementName the element name
     * @param elementValue the element value
     */
    public static void setElementValueToNode(XmlSerializer serializer, String elementName, Object elementValue) throws IOException {
    	if (elementValue != null) {
    		serializer.startTag(null, elementName).text(elementValue.toString()).endTag(null, elementName);
    	}
    }

    /**
     * Sets the element value.
     * 
     * @param node the node
     * @param elementValue the element value
     */
    public static void setElementValue(XmlSerializer serializer, Object elementValue) throws IOException {
    	if (elementValue != null) {
    		serializer.text(elementValue.toString());
    	}
    }
    
    /**
     * Sets the attribute value to node.
     * 
     * @param node the node
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     */
    public static void setAttributeValueToNode(XmlSerializer serializer, String attributeName, Object attributeValue) throws IOException {
    	if (attributeValue != null) {
    		serializer.attribute(null, attributeName, String.valueOf(attributeValue));
    	}
    }
    
    /**
     * Gets the element value from node.
     * 
     * @param node the node
     * @param valueName the value name
     * 
     * @return the element value from node
     * @throws IOException 
     * @throws XmlPullParserException 
     */
    public static String getElementValueFromNode(XmlPullParser node) throws XmlPullParserException, IOException {
    	return node.nextText();
    }

    /**
     * Gets the element value as long from node.
     * 
     * @param node the node
     * @param valueName the value name
     * 
     * @return the element value as long from node
     * @throws XmlPullParserException 
     */
    public static Long getElementValueAsLongFromNode(XmlPullParser node) throws IOException, XmlPullParserException {
    	String value = node.nextText();
    	if (isNullOrEmpty(value)) {
    		return null;
    	} else {
            return Long.valueOf(value);
    	}
    }
    

    /**
     * Gets the attribute value from node.
     * 
     * @param node the node
     * @param attributeName the attribute name
     * 
     * @return the attribute value from node
     */
    public static String getAttributeValueFromNode(XmlPullParser node, String attributeName) {
        return node.getAttributeValue(null, attributeName);
    }

    /**
     * Gets the attribute value as long from node.
     * 
     * @param node the node
     * @param attributeName the attribute name
     * 
     * @return the attribute value as long from node
     */
    public static Long getAttributeValueAsLongFromNode(XmlPullParser node, String attributeName) {
    	String attribute = node.getAttributeValue(null, attributeName);
    	if (isNullOrEmpty(attribute)) {
    		return null;
    	} else {
    		return Long.valueOf(attribute);
    	}
    }
    
    public static void skipSubTree(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, null);
        int level = 1;
        while (level > 0) {
            int eventType = parser.next();
            if (eventType == XmlPullParser.END_TAG) {
                --level;
            } else if (eventType == XmlPullParser.START_TAG) {
                ++level;
            }
        }
    }
    
	/**
     * Checks if is null or empty.
     * 
     * @param string the string
     * 
     * @return true, if is null or empty
     */
    private static boolean isNullOrEmpty(String string) {
    	return (string == null || string.length() == 0);
    }
}
