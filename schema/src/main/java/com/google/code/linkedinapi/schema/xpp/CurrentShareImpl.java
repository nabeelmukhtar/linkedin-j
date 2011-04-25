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

import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.Content;
import com.google.code.linkedinapi.schema.CurrentShare;
import com.google.code.linkedinapi.schema.Source;
import com.google.code.linkedinapi.schema.Visibility;

public class CurrentShareImpl
	extends BaseSchemaEntity
    implements CurrentShare
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected Long timestamp;
    protected String comment;
    protected ContentImpl content;
    protected VisibilityImpl visibility;
    protected SourceImpl source;
    protected AuthorImpl author;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content value) {
        this.content = ((ContentImpl) value);
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility value) {
        this.visibility = ((VisibilityImpl) value);
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source value) {
        this.source = ((SourceImpl) value);
    }
    
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author value) {
        this.author = ((AuthorImpl) value);
    }
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("timestamp")) {
        		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("comment")) {
        		setComment(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("content")) {
    			ContentImpl content = new ContentImpl();
    			content.init(parser);
    			setContent(content);
        	} else if (name.equals("visibility")) {
    			VisibilityImpl visibility = new VisibilityImpl();
    			visibility.init(parser);
    			setVisibility(visibility);
        	} else if (name.equals("source")) {
    			SourceImpl source = new SourceImpl();
    			source.init(parser);
    			setSource(source);
            } else if (name.equals("author")) {
    			AuthorImpl author = new AuthorImpl();
    			author.init(parser);
    			setAuthor(author);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "current-share");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "comment", getComment());
		if (getContent() != null) {
			((ContentImpl) getContent()).toXml(serializer);
		}
		if (getVisibility() != null) {
			((VisibilityImpl) getVisibility()).toXml(serializer);
		}
		if (getSource() != null) {
			((SourceImpl) getSource()).toXml(serializer);
		}
		if (getAuthor() != null) {
			((AuthorImpl) getAuthor()).toXml(serializer);
		}
		serializer.endTag(null, "current-share");
	}
    
}
