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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Content;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "title",
    "submittedUrl",
    "shortenedUrl",
    "submittedImageUrl",
    "thumbnailUrl",
    "resolvedUrl",
    "eyebrowUrl"
})
@XmlRootElement(name = "content")
public class ContentImpl
    implements Serializable, Content
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "submitted-url", required = true)
    protected String submittedUrl;
    @XmlElement(name = "shortened-url")
    protected String shortenedUrl;
    @XmlElement(name = "submitted-image-url", required = true)
    protected String submittedImageUrl;
    @XmlElement(name = "thumbnail-url")
    protected String thumbnailUrl;
    @XmlElement(name = "resolved-url")
    protected String resolvedUrl;
    @XmlElement(name = "eyebrow-url")
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

}
