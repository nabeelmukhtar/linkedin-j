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

import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.OriginalUpdate;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.UpdateContent;

public class OriginalUpdateImpl
	extends BaseSchemaEntity
    implements OriginalUpdate
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long timestamp;
    protected String updateKey;
    protected NetworkUpdateReturnType updateType;
    protected UpdateContentImpl updateContent;
    protected boolean isCommentable;
    protected UpdateCommentsImpl updateComments;
    protected boolean isLikable;
    protected boolean isLiked;
    protected Long numLikes;
    protected LikesImpl likes;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String value) {
        this.updateKey = value;
    }

    public NetworkUpdateReturnType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(NetworkUpdateReturnType value) {
        this.updateType = value;
    }

    public UpdateContent getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(UpdateContent value) {
        this.updateContent = ((UpdateContentImpl) value);
    }

    public boolean isIsCommentable() {
        return isCommentable;
    }

    public void setIsCommentable(boolean value) {
        this.isCommentable = value;
    }

    public UpdateComments getUpdateComments() {
        return updateComments;
    }

    public void setUpdateComments(UpdateComments value) {
        this.updateComments = ((UpdateCommentsImpl) value);
    }

    public boolean isIsLikable() {
        return isLikable;
    }

    public void setIsLikable(boolean value) {
        this.isLikable = value;
    }

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean value) {
        this.isLiked = value;
    }

    public Long getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Long value) {
        this.numLikes = value;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes value) {
        this.likes = ((LikesImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("timestamp")) {
        		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("update-key")) {
        		setUpdateKey(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("update-type")) {
        		setUpdateType(NetworkUpdateReturnType.fromValue(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("is-commentable")) {
        		setIsCommentable(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("is-likable")) {
        		setIsLikable(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("is-liked")) {
        		setIsLiked(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("num-likes")) {
        		setNumLikes(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("update-content")) {
    			UpdateContentImpl contentImpl = new UpdateContentImpl();
    			contentImpl.init(parser);
    			setUpdateContent(contentImpl);
        	} else if (name.equals("update-comments")) {
    			UpdateCommentsImpl commentImpl = new UpdateCommentsImpl();
    			commentImpl.init(parser);
    			setUpdateComments(commentImpl);
            } else if (name.equals("likes")) {
    			LikesImpl likesImpl = new LikesImpl();
    			likesImpl.init(parser);
    			setLikes(likesImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "original-update");
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "update-key", getUpdateKey());
		XppUtils.setElementValueToNode(element, "update-type", getUpdateType().value());
		XppUtils.setElementValueToNode(element, "is-commentable", String.valueOf(isIsCommentable()));
		XppUtils.setElementValueToNode(element, "is-likable", String.valueOf(isIsLikable()));
		XppUtils.setElementValueToNode(element, "is-liked", String.valueOf(isIsLiked()));
		XppUtils.setElementValueToNode(element, "num-likes", getNumLikes());
		
		if (getUpdateContent() != null) {
			((UpdateContentImpl) getUpdateContent()).toXml(serializer);
		}
		if (getUpdateComments() != null) {
			((UpdateCommentsImpl) getUpdateComments()).toXml(serializer);
		}
		if (getLikes() != null) {
			((LikesImpl) getLikes()).toXml(serializer);
		}
		serializer.endTag(null, "original-update");
	}
}
