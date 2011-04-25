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

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.CompanyPersonUpdate;
import com.google.code.linkedinapi.schema.NewPosition;
import com.google.code.linkedinapi.schema.OldPosition;
import com.google.code.linkedinapi.schema.Person;

public class CompanyPersonUpdateImpl
	extends BaseSchemaEntity
	implements CompanyPersonUpdate
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected PersonImpl person;
    protected ActionImpl action;
    protected OldPositionImpl oldPosition;
    protected NewPositionImpl newPosition;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public OldPosition getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(OldPosition value) {
        this.oldPosition = ((OldPositionImpl) value);
    }

    public NewPosition getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(NewPosition value) {
        this.newPosition = ((NewPositionImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("person")) {
        		PersonImpl author = new PersonImpl();
    			author.init(parser);
    			setPerson(author);
        	} else if (name.equals("action")) {
        		ActionImpl author = new ActionImpl();
    			author.init(parser);
    			setAction(author);
        	} else if (name.equals("old-position")) {
        		OldPositionImpl author = new OldPositionImpl();
    			author.init(parser);
    			setOldPosition(author);
        	} else if (name.equals("new-position")) {
        		NewPositionImpl author = new NewPositionImpl();
    			author.init(parser);
    			setNewPosition(author);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "company-person-update");
		if (getPerson() != null) {
			((PersonImpl) getPerson()).toXml(serializer);
		}
		if (getAction() != null) {
			((ActionImpl) getAction()).toXml(serializer);
		}
		if (getOldPosition() != null) {
			((OldPositionImpl) getOldPosition()).toXml(serializer);
		}
		if (getNewPosition() != null) {
			((NewPositionImpl) getNewPosition()).toXml(serializer);
		}
		element.endTag(null, "company-person-update");;
	}
}
