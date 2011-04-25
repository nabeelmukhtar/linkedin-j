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
 *         &lt;element ref="{}person"/>
 *         &lt;element ref="{}action"/>
 *         &lt;element ref="{}old-position"/>
 *         &lt;element ref="{}new-position"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface CompanyPersonUpdate
    extends SchemaEntity
{


    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    Person getPerson();

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    void setPerson(Person value);

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link Action }
     *     
     */
    Action getAction();

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link Action }
     *     
     */
    void setAction(Action value);

    /**
     * Gets the value of the oldPosition property.
     * 
     * @return
     *     possible object is
     *     {@link OldPosition }
     *     
     */
    OldPosition getOldPosition();

    /**
     * Sets the value of the oldPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link OldPosition }
     *     
     */
    void setOldPosition(OldPosition value);

    /**
     * Gets the value of the newPosition property.
     * 
     * @return
     *     possible object is
     *     {@link NewPosition }
     *     
     */
    NewPosition getNewPosition();

    /**
     * Sets the value of the newPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewPosition }
     *     
     */
    void setNewPosition(NewPosition value);

}
