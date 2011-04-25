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
 *         &lt;element ref="{}person" minOccurs="0"/>
 *         &lt;element ref="{}update-action" minOccurs="0"/>
 *         &lt;element ref="{}job" minOccurs="0"/>
 *         &lt;element ref="{}question" minOccurs="0"/>
 *         &lt;element ref="{}company" minOccurs="0"/>
 *         &lt;element ref="{}company-job-update" minOccurs="0"/>
 *         &lt;element ref="{}company-person-update" minOccurs="0"/>
 *         &lt;element ref="{}company-profile-update" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface UpdateContent
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
     * Gets the value of the updateAction property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateAction }
     *     
     */
    UpdateAction getUpdateAction();

    /**
     * Sets the value of the updateAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateAction }
     *     
     */
    void setUpdateAction(UpdateAction value);

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link Job }
     *     
     */
    Job getJob();

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link Job }
     *     
     */
    void setJob(Job value);

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link Question }
     *     
     */
    Question getQuestion();

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link Question }
     *     
     */
    void setQuestion(Question value);

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    Company getCompany();

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    void setCompany(Company value);

    /**
     * Gets the value of the companyJobUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyJobUpdate }
     *     
     */
    CompanyJobUpdate getCompanyJobUpdate();

    /**
     * Sets the value of the companyJobUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyJobUpdate }
     *     
     */
    void setCompanyJobUpdate(CompanyJobUpdate value);

    /**
     * Gets the value of the companyPersonUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyPersonUpdate }
     *     
     */
    CompanyPersonUpdate getCompanyPersonUpdate();

    /**
     * Sets the value of the companyPersonUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyPersonUpdate }
     *     
     */
    void setCompanyPersonUpdate(CompanyPersonUpdate value);

    /**
     * Gets the value of the companyProfileUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyProfileUpdate }
     *     
     */
    CompanyProfileUpdate getCompanyProfileUpdate();

    /**
     * Sets the value of the companyProfileUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyProfileUpdate }
     *     
     */
    void setCompanyProfileUpdate(CompanyProfileUpdate value);

}
