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

package com.google.code.linkedinapi.schema;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}id" minOccurs="0"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}submitted-url"/>
 *         &lt;element ref="{}shortened-url" minOccurs="0"/>
 *         &lt;element ref="{}submitted-image-url"/>
 *         &lt;element ref="{}thumbnail-url" minOccurs="0"/>
 *         &lt;element ref="{}resolved-url" minOccurs="0"/>
 *         &lt;element ref="{}eyebrow-url" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Content
    extends SchemaEntity
{


    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getId();

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setId(String value);

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getTitle();

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setTitle(String value);

    /**
     * Gets the value of the submittedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSubmittedUrl();

    /**
     * Sets the value of the submittedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSubmittedUrl(String value);

    /**
     * Gets the value of the shortenedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getShortenedUrl();

    /**
     * Sets the value of the shortenedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setShortenedUrl(String value);

    /**
     * Gets the value of the submittedImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSubmittedImageUrl();

    /**
     * Sets the value of the submittedImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSubmittedImageUrl(String value);

    /**
     * Gets the value of the thumbnailUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getThumbnailUrl();

    /**
     * Sets the value of the thumbnailUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setThumbnailUrl(String value);

    /**
     * Gets the value of the resolvedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getResolvedUrl();

    /**
     * Sets the value of the resolvedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setResolvedUrl(String value);

    /**
     * Gets the value of the eyebrowUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getEyebrowUrl();

    /**
     * Sets the value of the eyebrowUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setEyebrowUrl(String value);

}
