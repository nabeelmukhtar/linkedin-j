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

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
public class ActivityImpl
    extends BaseSchemaEntity
    implements Activity
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2002088204138306557L;
	protected Long timestamp;
    protected NetworkUpdateContentType contentType;
    protected String body;
    protected String locale;
    protected String appId;
    
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public NetworkUpdateContentType getContentType() {
        return contentType;
    }

    public void setContentType(NetworkUpdateContentType value) {
        this.contentType = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String value) {
        this.locale = value;
    }
    
    public String getAppId() {
        return appId;
    }

    public void setAppId(String value) {
        this.appId = value;
    }
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setLocale(XppUtils.getAttributeValueFromNode(parser, "locale"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	if (name.equals("timestamp")) {
        		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("content-type")) {
        		String contentTypeStr = XppUtils.getElementValueFromNode(parser);
        		if (contentTypeStr != null) {
        			setContentType(NetworkUpdateContentType.fromValue(contentTypeStr));
        		}
        	} else if (name.equals("body")) {
        		setBody(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("app-id")) {
        		setAppId(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "activity");
		XppUtils.setAttributeValueToNode(element, "locale", getLocale());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "content-type", getContentType().value());
		XppUtils.setElementValueToNode(element, "body", getBody());
		XppUtils.setElementValueToNode(element, "app-id", getAppId());
		element.endTag(null, "activity");
	}
}
