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

import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComment;

public class UpdateCommentImpl
	extends BaseSchemaEntity
    implements UpdateComment
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8511084386767332742L;
    protected String id;
	protected Long sequenceNumber;
    protected String comment;
    protected PersonImpl person;
    protected Long timestamp;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }
    
    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long value) {
        this.sequenceNumber = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }
    
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("sequence-number")) {
        		setSequenceNumber(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("comment")) {
        		setComment(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("timestamp")) {
        		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("person")) {
    			PersonImpl person = new PersonImpl();
    			person.init(parser);
    			setPerson(person);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "update-comment");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "comment", getComment());
		XppUtils.setElementValueToNode(element, "sequence-number", getSequenceNumber());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		if (getPerson() != null) {
			((PersonImpl) getPerson()).toXml(serializer);
		}
		serializer.endTag(null, "update-comment");
	}
}
