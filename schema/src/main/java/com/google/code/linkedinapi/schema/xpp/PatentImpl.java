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

import com.google.code.linkedinapi.schema.Date;
import com.google.code.linkedinapi.schema.Inventors;
import com.google.code.linkedinapi.schema.Office;
import com.google.code.linkedinapi.schema.Patent;
import com.google.code.linkedinapi.schema.Status;

public class PatentImpl
	extends BaseSchemaEntity
    implements Patent
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String title;
    protected DateImpl date;
    protected String url;
    protected String summary;
    protected String number;
    protected StatusImpl status;
    protected OfficeImpl office;
    protected InventorsImpl inventors;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = ((DateImpl) value);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String value) {
        this.number = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status value) {
        this.status = ((StatusImpl) value);
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office value) {
        this.office = ((OfficeImpl) value);
    }

    public Inventors getInventors() {
        return inventors;
    }

    public void setInventors(Inventors value) {
        this.inventors = ((InventorsImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("title")) {
        		setTitle(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("url")) {
        		setUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("summary")) {
        		setSummary(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("number")) {
        		setNumber(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("date")) {
    			DateImpl author = new DateImpl();
    			author.init(parser);
    			setDate(author);
        	} else if (name.equals("status")) {
    			StatusImpl author = new StatusImpl();
    			author.init(parser);
    			setStatus(author);
        	} else if (name.equals("office")) {
    			OfficeImpl author = new OfficeImpl();
    			author.init(parser);
    			setOffice(author);
        	} else if (name.equals("inventors")) {
    			InventorsImpl author = new InventorsImpl();
    			author.init(parser);
    			setInventors(author);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "patent");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "title", getTitle());
		XppUtils.setElementValueToNode(element, "url", getUrl());
		XppUtils.setElementValueToNode(element, "summary", getSummary());
		XppUtils.setElementValueToNode(element, "number", getNumber());
		if (getDate() != null) {
			((DateImpl) getDate()).toXml(serializer);
		}
		if (getStatus() != null) {
			((StatusImpl) getStatus()).toXml(serializer);
		}
		if (getOffice() != null) {
			((OfficeImpl) getOffice()).toXml(serializer);
		}
		if (getInventors() != null) {
			((InventorsImpl) getInventors()).toXml(serializer);
		}
		element.endTag(null, "patent");
	}
}
