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

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Editor;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class EditorImpl
	extends BaseSchemaEntity
    implements Editor
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String headline;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String value) {
        this.headline = value;
    }

    public ApiStandardProfileRequest getApiStandardProfileRequest() {
        return apiStandardProfileRequest;
    }

    public void setApiStandardProfileRequest(ApiStandardProfileRequest value) {
        this.apiStandardProfileRequest = ((ApiStandardProfileRequestImpl) value);
    }

    public SiteStandardProfileRequest getSiteStandardProfileRequest() {
        return siteStandardProfileRequest;
    }

    public void setSiteStandardProfileRequest(SiteStandardProfileRequest value) {
        this.siteStandardProfileRequest = ((SiteStandardProfileRequestImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("first-name")) {
        		setFirstName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("last-name")) {
        		setLastName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("headline")) {
        		setHeadline(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("api-standard-profile-request")) {
    			ApiStandardProfileRequestImpl apiRequest = new ApiStandardProfileRequestImpl();
    			apiRequest.init(parser);
    			setApiStandardProfileRequest(apiRequest);
        	} else if (name.equals("site-standard-profile-request")) {
    			SiteStandardProfileRequestImpl apiRequest = new SiteStandardProfileRequestImpl();
    			apiRequest.init(parser);
    			setSiteStandardProfileRequest(apiRequest);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "editor");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "first-name", getFirstName());
		XppUtils.setElementValueToNode(element, "last-name", getLastName());
		XppUtils.setElementValueToNode(element, "headline", getHeadline());
		if (getApiStandardProfileRequest() != null) {
			((ApiStandardProfileRequestImpl) getApiStandardProfileRequest()).toXml(serializer);
		}
		if (getSiteStandardProfileRequest() != null) {
			((SiteStandardProfileRequestImpl) getSiteStandardProfileRequest()).toXml(serializer);
		}
		serializer.endTag(null, "editor");
	}
}
