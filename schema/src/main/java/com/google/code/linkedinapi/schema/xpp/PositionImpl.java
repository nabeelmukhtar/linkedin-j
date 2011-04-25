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

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.StartDate;

public class PositionImpl
    extends BaseSchemaEntity
    implements Position
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4485115686667474338L;
	protected String id;
    protected String title;
    protected String summary;
    protected StartDateImpl startDate;
    protected EndDateImpl endDate;
    protected boolean isCurrent;
    protected CompanyImpl company;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate value) {
        this.startDate = ((StartDateImpl) value);
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate value) {
        this.endDate = ((EndDateImpl) value);
    }

    public Boolean isIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean value) {
        this.isCurrent = value;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
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
        	} else if (name.equals("summary")) {
        		setSummary(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("is-current")) {
        		setIsCurrent(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("company")) {
    			CompanyImpl companyImpl = new CompanyImpl();
    			companyImpl.init(parser);
    			setCompany(companyImpl);
        	} else if (name.equals("start-date")) {
    			StartDateImpl startDateImpl = new StartDateImpl();
    			startDateImpl.init(parser);
    			setStartDate(startDateImpl);
        	} else if (name.equals("end-date")) {
    			EndDateImpl endDate = new EndDateImpl();
    			endDate.init(parser);
    			setEndDate(endDate);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "position");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "title", getTitle());
		XppUtils.setElementValueToNode(element, "summary", getSummary());
		XppUtils.setElementValueToNode(element, "is-current", String.valueOf(isIsCurrent()));
		
		if (getCompany() != null) {
			((CompanyImpl) getCompany()).toXml(serializer);
		}
		if (getStartDate() != null) {
			((StartDateImpl) getStartDate()).toXml(serializer);
		}
		if (getEndDate() != null) {
			((EndDateImpl) getEndDate()).toXml(serializer);
		}
		serializer.endTag(null, "position");
	}
}
