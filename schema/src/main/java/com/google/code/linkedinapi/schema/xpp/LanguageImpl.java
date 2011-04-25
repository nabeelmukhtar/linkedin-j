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

import com.google.code.linkedinapi.schema.Language;
import com.google.code.linkedinapi.schema.NameType;
import com.google.code.linkedinapi.schema.Proficiency;

public class LanguageImpl
	extends BaseSchemaEntity
    implements Language
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected ProficiencyImpl proficiency;
    protected String id;
    protected NameTypeImpl language;

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency value) {
        this.proficiency = ((ProficiencyImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public NameType getLanguage() {
        return language;
    }

    public void setLanguage(NameType value) {
        this.language = ((NameTypeImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("language")) {
        		NameTypeImpl author = new NameTypeImpl();
    			author.init(parser);
    			setLanguage(author);
        	} else if (name.equals("proficiency")) {
        		ProficiencyImpl author = new ProficiencyImpl();
    			author.init(parser);
    			setProficiency(author);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "language");
		XppUtils.setElementValueToNode(element, "id", getId());
		if (getLanguage() != null) {
			((NameTypeImpl) getLanguage()).toXml(serializer);
		}
		if (getProficiency() != null) {
			((ProficiencyImpl) getProficiency()).toXml(serializer);
		}
		element.endTag(null, "language");;
	}
}
