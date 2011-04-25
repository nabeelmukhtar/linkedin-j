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
import com.google.code.linkedinapi.schema.OriginalUpdate;
import com.google.code.linkedinapi.schema.UpdateAction;

public class UpdateActionImpl
	extends BaseSchemaEntity
    implements UpdateAction
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected ActionImpl action;
    protected OriginalUpdateImpl originalUpdate;

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public OriginalUpdate getOriginalUpdate() {
        return originalUpdate;
    }

    public void setOriginalUpdate(OriginalUpdate value) {
        this.originalUpdate = ((OriginalUpdateImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("action")) {
        		ActionImpl actionImpl = new ActionImpl();
    			actionImpl.init(parser);
    			setAction(actionImpl);
        	} else if (name.equals("original-update")) {
        		OriginalUpdateImpl updateImpl = new OriginalUpdateImpl();
    			updateImpl.init(parser);
    			setOriginalUpdate(updateImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		serializer.startTag(null, "update-action");
		
		if (getAction() != null) {
			((ActionImpl) getAction()).toXml(serializer);
		}
		if (getOriginalUpdate() != null) {
			((OriginalUpdateImpl) getOriginalUpdate()).toXml(serializer);
		}
		serializer.endTag(null, "update-action");
	}
}
