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
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}first-name"/>
 *           &lt;element ref="{}last-name"/>
 *           &lt;element ref="{}headline"/>
 *         &lt;/sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}location"/>
 *           &lt;element ref="{}industry"/>
 *         &lt;/sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}connections"/>
 *           &lt;element ref="{}current-status"/>
 *           &lt;element ref="{}current-share"/>
 *           &lt;element ref="{}distance"/>
 *           &lt;element ref="{}current-status-timestamp"/>
 *           &lt;element ref="{}num-recommenders"/>
 *           &lt;element ref="{}num-connections"/>
 *           &lt;element ref="{}num-connections-capped"/>
 *           &lt;element ref="{}relation-to-viewer"/>
 *           &lt;element ref="{}summary"/>
 *           &lt;element ref="{}public-profile-url"/>
 *           &lt;element ref="{}interests"/>
 *           &lt;element ref="{}associations"/>
 *           &lt;element ref="{}honors"/>
 *           &lt;element ref="{}specialties"/>
 *           &lt;element ref="{}certifications"/>
 *           &lt;element ref="{}patents"/>
 *           &lt;element ref="{}publications"/>
 *           &lt;element ref="{}skills"/>
 *           &lt;element ref="{}languages"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}positions" minOccurs="0"/>
 *         &lt;element ref="{}three-current-positions" minOccurs="0"/>
 *         &lt;element ref="{}three-past-positions" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}educations"/>
 *           &lt;element ref="{}member-url-resources"/>
 *         &lt;/sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}api-standard-profile-request"/>
 *           &lt;element ref="{}site-standard-profile-request"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}picture-url" minOccurs="0"/>
 *         &lt;element ref="{}recommendations-given" minOccurs="0"/>
 *         &lt;element ref="{}recommendations-received" minOccurs="0"/>
 *         &lt;element ref="{}member-groups" minOccurs="0"/>
 *         &lt;element ref="{}person-activities" minOccurs="0"/>
 *         &lt;element ref="{}im-accounts" minOccurs="0"/>
 *         &lt;element ref="{}twitter-accounts" minOccurs="0"/>
 *         &lt;element ref="{}date-of-birth" minOccurs="0"/>
 *         &lt;element ref="{}main-address" minOccurs="0"/>
 *         &lt;element ref="{}phone-numbers" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="path" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Person
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
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getFirstName();

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setFirstName(String value);

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getLastName();

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setLastName(String value);

    /**
     * Gets the value of the headline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getHeadline();

    /**
     * Sets the value of the headline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setHeadline(String value);

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    Location getLocation();

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    void setLocation(Location value);

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getIndustry();

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setIndustry(String value);

    /**
     * Gets the value of the connections property.
     * 
     * @return
     *     possible object is
     *     {@link Connections }
     *     
     */
    Connections getConnections();

    /**
     * Sets the value of the connections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Connections }
     *     
     */
    void setConnections(Connections value);

    /**
     * Gets the value of the currentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getCurrentStatus();

    /**
     * Sets the value of the currentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setCurrentStatus(String value);

    /**
     * Gets the value of the currentShare property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentShare }
     *     
     */
    CurrentShare getCurrentShare();

    /**
     * Sets the value of the currentShare property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentShare }
     *     
     */
    void setCurrentShare(CurrentShare value);

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getDistance();

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setDistance(Long value);

    /**
     * Gets the value of the currentStatusTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getCurrentStatusTimestamp();

    /**
     * Sets the value of the currentStatusTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setCurrentStatusTimestamp(Long value);

    /**
     * Gets the value of the numRecommenders property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getNumRecommenders();

    /**
     * Sets the value of the numRecommenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setNumRecommenders(Long value);

    /**
     * Gets the value of the numConnections property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getNumConnections();

    /**
     * Sets the value of the numConnections property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setNumConnections(Long value);

    /**
     * Gets the value of the numConnectionsCapped property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    Boolean isNumConnectionsCapped();

    /**
     * Sets the value of the numConnectionsCapped property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    void setNumConnectionsCapped(Boolean value);

    /**
     * Gets the value of the relationToViewer property.
     * 
     * @return
     *     possible object is
     *     {@link RelationToViewer }
     *     
     */
    RelationToViewer getRelationToViewer();

    /**
     * Sets the value of the relationToViewer property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationToViewer }
     *     
     */
    void setRelationToViewer(RelationToViewer value);

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSummary();

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSummary(String value);

    /**
     * Gets the value of the publicProfileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getPublicProfileUrl();

    /**
     * Sets the value of the publicProfileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setPublicProfileUrl(String value);

    /**
     * Gets the value of the interests property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getInterests();

    /**
     * Sets the value of the interests property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setInterests(String value);

    /**
     * Gets the value of the associations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getAssociations();

    /**
     * Sets the value of the associations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setAssociations(String value);

    /**
     * Gets the value of the honors property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getHonors();

    /**
     * Sets the value of the honors property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setHonors(String value);

    /**
     * Gets the value of the specialties property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getSpecialties();

    /**
     * Sets the value of the specialties property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setSpecialties(String value);

    /**
     * Gets the value of the certifications property.
     * 
     * @return
     *     possible object is
     *     {@link Certifications }
     *     
     */
    Certifications getCertifications();

    /**
     * Sets the value of the certifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certifications }
     *     
     */
    void setCertifications(Certifications value);

    /**
     * Gets the value of the patents property.
     * 
     * @return
     *     possible object is
     *     {@link Patents }
     *     
     */
    Patents getPatents();

    /**
     * Sets the value of the patents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patents }
     *     
     */
    void setPatents(Patents value);

    /**
     * Gets the value of the publications property.
     * 
     * @return
     *     possible object is
     *     {@link Publications }
     *     
     */
    Publications getPublications();

    /**
     * Sets the value of the publications property.
     * 
     * @param value
     *     allowed object is
     *     {@link Publications }
     *     
     */
    void setPublications(Publications value);

    /**
     * Gets the value of the skills property.
     * 
     * @return
     *     possible object is
     *     {@link Skills }
     *     
     */
    Skills getSkills();

    /**
     * Sets the value of the skills property.
     * 
     * @param value
     *     allowed object is
     *     {@link Skills }
     *     
     */
    void setSkills(Skills value);

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link Languages }
     *     
     */
    Languages getLanguages();

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Languages }
     *     
     */
    void setLanguages(Languages value);

    /**
     * Gets the value of the positions property.
     * 
     * @return
     *     possible object is
     *     {@link Positions }
     *     
     */
    Positions getPositions();

    /**
     * Sets the value of the positions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Positions }
     *     
     */
    void setPositions(Positions value);

    /**
     * Gets the value of the threeCurrentPositions property.
     * 
     * @return
     *     possible object is
     *     {@link ThreeCurrentPositions }
     *     
     */
    ThreeCurrentPositions getThreeCurrentPositions();

    /**
     * Sets the value of the threeCurrentPositions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreeCurrentPositions }
     *     
     */
    void setThreeCurrentPositions(ThreeCurrentPositions value);

    /**
     * Gets the value of the threePastPositions property.
     * 
     * @return
     *     possible object is
     *     {@link ThreePastPositions }
     *     
     */
    ThreePastPositions getThreePastPositions();

    /**
     * Sets the value of the threePastPositions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreePastPositions }
     *     
     */
    void setThreePastPositions(ThreePastPositions value);

    /**
     * Gets the value of the educations property.
     * 
     * @return
     *     possible object is
     *     {@link Educations }
     *     
     */
    Educations getEducations();

    /**
     * Sets the value of the educations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Educations }
     *     
     */
    void setEducations(Educations value);

    /**
     * Gets the value of the memberUrlResources property.
     * 
     * @return
     *     possible object is
     *     {@link MemberUrlResources }
     *     
     */
    MemberUrlResources getMemberUrlResources();

    /**
     * Sets the value of the memberUrlResources property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberUrlResources }
     *     
     */
    void setMemberUrlResources(MemberUrlResources value);

    /**
     * Gets the value of the apiStandardProfileRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ApiStandardProfileRequest }
     *     
     */
    ApiStandardProfileRequest getApiStandardProfileRequest();

    /**
     * Sets the value of the apiStandardProfileRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiStandardProfileRequest }
     *     
     */
    void setApiStandardProfileRequest(ApiStandardProfileRequest value);

    /**
     * Gets the value of the siteStandardProfileRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SiteStandardProfileRequest }
     *     
     */
    SiteStandardProfileRequest getSiteStandardProfileRequest();

    /**
     * Sets the value of the siteStandardProfileRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteStandardProfileRequest }
     *     
     */
    void setSiteStandardProfileRequest(SiteStandardProfileRequest value);

    /**
     * Gets the value of the pictureUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getPictureUrl();

    /**
     * Sets the value of the pictureUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setPictureUrl(String value);

    /**
     * Gets the value of the recommendationsGiven property.
     * 
     * @return
     *     possible object is
     *     {@link RecommendationsGiven }
     *     
     */
    RecommendationsGiven getRecommendationsGiven();

    /**
     * Sets the value of the recommendationsGiven property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecommendationsGiven }
     *     
     */
    void setRecommendationsGiven(RecommendationsGiven value);

    /**
     * Gets the value of the recommendationsReceived property.
     * 
     * @return
     *     possible object is
     *     {@link RecommendationsReceived }
     *     
     */
    RecommendationsReceived getRecommendationsReceived();

    /**
     * Sets the value of the recommendationsReceived property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecommendationsReceived }
     *     
     */
    void setRecommendationsReceived(RecommendationsReceived value);

    /**
     * Gets the value of the memberGroups property.
     * 
     * @return
     *     possible object is
     *     {@link MemberGroups }
     *     
     */
    MemberGroups getMemberGroups();

    /**
     * Sets the value of the memberGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberGroups }
     *     
     */
    void setMemberGroups(MemberGroups value);

    /**
     * Gets the value of the personActivities property.
     * 
     * @return
     *     possible object is
     *     {@link PersonActivities }
     *     
     */
    PersonActivities getPersonActivities();

    /**
     * Sets the value of the personActivities property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonActivities }
     *     
     */
    void setPersonActivities(PersonActivities value);

    /**
     * Gets the value of the imAccounts property.
     * 
     * @return
     *     possible object is
     *     {@link ImAccounts }
     *     
     */
    ImAccounts getImAccounts();

    /**
     * Sets the value of the imAccounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImAccounts }
     *     
     */
    void setImAccounts(ImAccounts value);

    /**
     * Gets the value of the twitterAccounts property.
     * 
     * @return
     *     possible object is
     *     {@link TwitterAccounts }
     *     
     */
    TwitterAccounts getTwitterAccounts();

    /**
     * Sets the value of the twitterAccounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TwitterAccounts }
     *     
     */
    void setTwitterAccounts(TwitterAccounts value);

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link DateOfBirth }
     *     
     */
    DateOfBirth getDateOfBirth();

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateOfBirth }
     *     
     */
    void setDateOfBirth(DateOfBirth value);

    /**
     * Gets the value of the mainAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getMainAddress();

    /**
     * Sets the value of the mainAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setMainAddress(String value);

    /**
     * Gets the value of the phoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneNumbers }
     *     
     */
    PhoneNumbers getPhoneNumbers();

    /**
     * Sets the value of the phoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneNumbers }
     *     
     */
    void setPhoneNumbers(PhoneNumbers value);

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getPath();

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setPath(String value);

}
