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

import com.google.code.linkedinapi.schema.Content;

public class ContentImpl
	extends BaseSchemaEntity
    implements Content
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String title;
    protected String submittedUrl;
    protected String shortenedUrl;
    protected String submittedImageUrl;
    protected String thumbnailUrl;
    protected String resolvedUrl;
    protected String eyebrowUrl;
    

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

    public String getSubmittedUrl() {
        return submittedUrl;
    }

    public void setSubmittedUrl(String value) {
        this.submittedUrl = value;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String value) {
        this.shortenedUrl = value;
    }

    public String getSubmittedImageUrl() {
        return submittedImageUrl;
    }

    public void setSubmittedImageUrl(String value) {
        this.submittedImageUrl = value;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String value) {
        this.thumbnailUrl = value;
    }
    
    public String getResolvedUrl() {
        return resolvedUrl;
    }

    public void setResolvedUrl(String value) {
        this.resolvedUrl = value;
    }

    public String getEyebrowUrl() {
        return eyebrowUrl;
    }

    public void setEyebrowUrl(String value) {
        this.eyebrowUrl = value;
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
        	} else if (name.equals("submitted-url")) {
        		setSubmittedUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("shortened-url")) {
        		setShortenedUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("submitted-image-url")) {
        		setSubmittedImageUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("thumbnail-url")) {
        		setThumbnailUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("resolved-url")) {
        		setResolvedUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("eyebrow-url")) {
        		setEyebrowUrl(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "content");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "title", getTitle());
		XppUtils.setElementValueToNode(element, "submitted-url", getSubmittedUrl());
		XppUtils.setElementValueToNode(element, "shortened-url", getShortenedUrl());
		XppUtils.setElementValueToNode(element, "submitted-image-url", getSubmittedImageUrl());
		XppUtils.setElementValueToNode(element, "thumbnail-url", getThumbnailUrl());
		XppUtils.setElementValueToNode(element, "resolved-url", getResolvedUrl());
		XppUtils.setElementValueToNode(element, "eyebrow-url", getEyebrowUrl());
		serializer.endTag(null, "content");
	}
    
}
