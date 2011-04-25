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
 *         &lt;element ref="{}connect-type"/>
 *         &lt;element ref="{}authorization"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface InvitationRequest
    extends SchemaEntity
{


    /**
     * Gets the value of the connectType property.
     * 
     * @return
     *     possible object is
     *     {@link InviteConnectType }
     *     
     */
    InviteConnectType getConnectType();

    /**
     * Sets the value of the connectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InviteConnectType }
     *     
     */
    void setConnectType(InviteConnectType value);

    /**
     * Gets the value of the authorization property.
     * 
     * @return
     *     possible object is
     *     {@link Authorization }
     *     
     */
    Authorization getAuthorization();

    /**
     * Sets the value of the authorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Authorization }
     *     
     */
    void setAuthorization(Authorization value);

}
