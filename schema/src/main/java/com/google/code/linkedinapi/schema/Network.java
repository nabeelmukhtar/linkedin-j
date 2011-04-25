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
 *         &lt;element ref="{}network-stats"/>
 *         &lt;element ref="{}updates"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Network
    extends SchemaEntity
{


    /**
     * Gets the value of the networkStats property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkStats }
     *     
     */
    NetworkStats getNetworkStats();

    /**
     * Sets the value of the networkStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkStats }
     *     
     */
    void setNetworkStats(NetworkStats value);

    /**
     * Gets the value of the updates property.
     * 
     * @return
     *     possible object is
     *     {@link Updates }
     *     
     */
    Updates getUpdates();

    /**
     * Sets the value of the updates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Updates }
     *     
     */
    void setUpdates(Updates value);

}
