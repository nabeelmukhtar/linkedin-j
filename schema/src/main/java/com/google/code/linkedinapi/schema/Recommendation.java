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
 *         &lt;element ref="{}id"/>
 *         &lt;element ref="{}recommendation-type"/>
 *         &lt;element ref="{}recommendation-text" minOccurs="0"/>
 *         &lt;element ref="{}recommendation-snippet" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{}recommender"/>
 *           &lt;element ref="{}recommendee"/>
 *         &lt;/choice>
 *         &lt;element ref="{}web-url" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Recommendation
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
     * Gets the value of the recommendationType property.
     * 
     * @return
     *     possible object is
     *     {@link RecommendationType }
     *     
     */
    RecommendationType getRecommendationType();

    /**
     * Sets the value of the recommendationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecommendationType }
     *     
     */
    void setRecommendationType(RecommendationType value);

    /**
     * Gets the value of the recommendationText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getRecommendationText();

    /**
     * Sets the value of the recommendationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setRecommendationText(String value);

    /**
     * Gets the value of the recommendationSnippet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getRecommendationSnippet();

    /**
     * Sets the value of the recommendationSnippet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setRecommendationSnippet(String value);

    /**
     * Gets the value of the recommender property.
     * 
     * @return
     *     possible object is
     *     {@link Recommender }
     *     
     */
    Recommender getRecommender();

    /**
     * Sets the value of the recommender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recommender }
     *     
     */
    void setRecommender(Recommender value);

    /**
     * Gets the value of the recommendee property.
     * 
     * @return
     *     possible object is
     *     {@link Recommendee }
     *     
     */
    Recommendee getRecommendee();

    /**
     * Sets the value of the recommendee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recommendee }
     *     
     */
    void setRecommendee(Recommendee value);

    /**
     * Gets the value of the webUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getWebUrl();

    /**
     * Sets the value of the webUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setWebUrl(String value);

}
