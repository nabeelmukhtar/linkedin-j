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
import com.google.code.linkedinapi.schema.CompanyProfileUpdate;
import com.google.code.linkedinapi.schema.Editor;
import com.google.code.linkedinapi.schema.ProfileField;

public class CompanyProfileUpdateImpl
	extends BaseSchemaEntity
	implements CompanyProfileUpdate
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected EditorImpl editor;
    protected ActionImpl action;
    protected ProfileFieldImpl profileField;

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor value) {
        this.editor = ((EditorImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public ProfileField getProfileField() {
        return profileField;
    }

    public void setProfileField(ProfileField value) {
        this.profileField = ((ProfileFieldImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("editor")) {
        		EditorImpl author = new EditorImpl();
    			author.init(parser);
    			setEditor(author);
        	} else if (name.equals("action")) {
        		ActionImpl author = new ActionImpl();
    			author.init(parser);
    			setAction(author);
        	} else if (name.equals("profile-field")) {
        		ProfileFieldImpl author = new ProfileFieldImpl();
    			author.init(parser);
    			setProfileField(author);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "company-profile-update");
		if (getEditor() != null) {
			((EditorImpl) getEditor()).toXml(serializer);
		}
		if (getAction() != null) {
			((ActionImpl) getAction()).toXml(serializer);
		}
		if (getProfileField() != null) {
			((ProfileFieldImpl) getProfileField()).toXml(serializer);
		}
		element.endTag(null, "company-profile-update");;
	}
}
