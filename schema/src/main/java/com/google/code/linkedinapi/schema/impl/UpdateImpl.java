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

package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.UpdateContent;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "timestamp",
    "updateKey",
    "updateType",
    "updateContent",
    "isCommentable",
    "isLikable",
    "isLiked",
    "numLikes",
    "updateComments",
    "likes"
})
@XmlRootElement(name = "update")
public class UpdateImpl
    implements Serializable, Update
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long timestamp;
    @XmlElement(name = "update-key", required = true)
    protected String updateKey;
    @XmlElement(name = "update-type", required = true)
    protected NetworkUpdateReturnType updateType;
    @XmlElement(name = "update-content", required = true, type = UpdateContentImpl.class)
    protected UpdateContentImpl updateContent;
    @XmlElement(name = "is-commentable")
    protected boolean isCommentable;
    @XmlElement(name = "is-likable")
    protected boolean isLikable;
    @XmlElement(name = "is-liked")
    protected boolean isLiked;
    @XmlElement(name = "num-likes", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long numLikes;
    @XmlElement(name = "update-comments", type = UpdateCommentsImpl.class)
    protected UpdateCommentsImpl updateComments;
    @XmlElement(type = LikesImpl.class)
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

    public UpdateComments getUpdateComments() {
        return updateComments;
    }

    public void setUpdateComments(UpdateComments value) {
        this.updateComments = ((UpdateCommentsImpl) value);
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes value) {
        this.likes = ((LikesImpl) value);
    }

}
