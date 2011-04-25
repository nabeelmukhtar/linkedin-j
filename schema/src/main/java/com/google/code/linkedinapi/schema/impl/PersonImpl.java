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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Certifications;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.CurrentShare;
import com.google.code.linkedinapi.schema.DateOfBirth;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.ImAccounts;
import com.google.code.linkedinapi.schema.Languages;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MemberGroups;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Patents;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.PersonActivities;
import com.google.code.linkedinapi.schema.PhoneNumbers;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.Publications;
import com.google.code.linkedinapi.schema.RecommendationsGiven;
import com.google.code.linkedinapi.schema.RecommendationsReceived;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;
import com.google.code.linkedinapi.schema.Skills;
import com.google.code.linkedinapi.schema.ThreeCurrentPositions;
import com.google.code.linkedinapi.schema.ThreePastPositions;
import com.google.code.linkedinapi.schema.TwitterAccounts;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "firstName",
    "lastName",
    "headline",
    "location",
    "industry",
    "connections",
    "currentStatus",
    "currentShare",
    "distance",
    "currentStatusTimestamp",
    "numRecommenders",
    "numConnections",
    "numConnectionsCapped",
    "relationToViewer",
    "summary",
    "publicProfileUrl",
    "interests",
    "associations",
    "honors",
    "specialties",
    "certifications",
    "patents",
    "publications",
    "skills",
    "languages",
    "positions",
    "threeCurrentPositions",
    "threePastPositions",
    "educations",
    "memberUrlResources",
    "apiStandardProfileRequest",
    "siteStandardProfileRequest",
    "pictureUrl",
    "recommendationsGiven",
    "recommendationsReceived",
    "memberGroups",
    "personActivities",
    "imAccounts",
    "twitterAccounts",
    "dateOfBirth",
    "mainAddress",
    "phoneNumbers"
})
@XmlRootElement(name = "person")
public class PersonImpl
    implements Serializable, Person
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "first-name")
    protected String firstName;
    @XmlElement(name = "last-name")
    protected String lastName;
    protected String headline;
    @XmlElement(type = LocationImpl.class)
    protected LocationImpl location;
    protected String industry;
    @XmlElement(type = ConnectionsImpl.class)
    protected ConnectionsImpl connections;
    @XmlElement(name = "current-status")
    protected String currentStatus;
    @XmlElement(name = "current-share", type = CurrentShareImpl.class)
    protected CurrentShareImpl currentShare;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long distance;
    @XmlElement(name = "current-status-timestamp", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long currentStatusTimestamp;
    @XmlElement(name = "num-recommenders", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long numRecommenders;
    @XmlElement(name = "num-connections", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long numConnections;
    @XmlElement(name = "num-connections-capped")
    protected Boolean numConnectionsCapped;
    @XmlElement(name = "relation-to-viewer", type = RelationToViewerImpl.class)
    protected RelationToViewerImpl relationToViewer;
    protected String summary;
    @XmlElement(name = "public-profile-url")
    protected String publicProfileUrl;
    protected String interests;
    protected String associations;
    protected String honors;
    protected String specialties;
    @XmlElement(type = CertificationsImpl.class)
    protected CertificationsImpl certifications;
    @XmlElement(type = PatentsImpl.class)
    protected PatentsImpl patents;
    @XmlElement(type = PublicationsImpl.class)
    protected PublicationsImpl publications;
    @XmlElement(type = SkillsImpl.class)
    protected SkillsImpl skills;
    @XmlElement(type = LanguagesImpl.class)
    protected LanguagesImpl languages;
    @XmlElement(type = PositionsImpl.class)
    protected PositionsImpl positions;
    @XmlElement(name = "three-current-positions", type = ThreeCurrentPositionsImpl.class)
    protected ThreeCurrentPositionsImpl threeCurrentPositions;
    @XmlElement(name = "three-past-positions", type = ThreePastPositionsImpl.class)
    protected ThreePastPositionsImpl threePastPositions;
    @XmlElement(type = EducationsImpl.class)
    protected EducationsImpl educations;
    @XmlElement(name = "member-url-resources", type = MemberUrlResourcesImpl.class)
    protected MemberUrlResourcesImpl memberUrlResources;
    @XmlElement(name = "api-standard-profile-request", type = ApiStandardProfileRequestImpl.class)
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    @XmlElement(name = "site-standard-profile-request", type = SiteStandardProfileRequestImpl.class)
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;
    @XmlElement(name = "picture-url")
    protected String pictureUrl;
    @XmlElement(name = "recommendations-given", type = RecommendationsGivenImpl.class)
    protected RecommendationsGivenImpl recommendationsGiven;
    @XmlElement(name = "recommendations-received", type = RecommendationsReceivedImpl.class)
    protected RecommendationsReceivedImpl recommendationsReceived;
    @XmlElement(name = "member-groups", type = MemberGroupsImpl.class)
    protected MemberGroupsImpl memberGroups;
    @XmlElement(name = "person-activities", type = PersonActivitiesImpl.class)
    protected PersonActivitiesImpl personActivities;
    @XmlElement(name = "im-accounts", type = ImAccountsImpl.class)
    protected ImAccountsImpl imAccounts;
    @XmlElement(name = "twitter-accounts", type = TwitterAccountsImpl.class)
    protected TwitterAccountsImpl twitterAccounts;
    @XmlElement(name = "date-of-birth", type = DateOfBirthImpl.class)
    protected DateOfBirthImpl dateOfBirth;
    @XmlElement(name = "main-address")
    protected String mainAddress;
    @XmlElement(name = "phone-numbers", type = PhoneNumbersImpl.class)
    protected PhoneNumbersImpl phoneNumbers;
    @XmlAttribute
    protected String path;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String value) {
        this.headline = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location value) {
        this.location = ((LocationImpl) value);
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String value) {
        this.industry = value;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections value) {
        this.connections = ((ConnectionsImpl) value);
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String value) {
        this.currentStatus = value;
    }

    public CurrentShare getCurrentShare() {
        return currentShare;
    }

    public void setCurrentShare(CurrentShare value) {
        this.currentShare = ((CurrentShareImpl) value);
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }

    public Long getCurrentStatusTimestamp() {
        return currentStatusTimestamp;
    }

    public void setCurrentStatusTimestamp(Long value) {
        this.currentStatusTimestamp = value;
    }

    public Long getNumRecommenders() {
        return numRecommenders;
    }

    public void setNumRecommenders(Long value) {
        this.numRecommenders = value;
    }

    public Long getNumConnections() {
        return numConnections;
    }

    public void setNumConnections(Long value) {
        this.numConnections = value;
    }

    public Boolean isNumConnectionsCapped() {
        return numConnectionsCapped;
    }

    public void setNumConnectionsCapped(Boolean value) {
        this.numConnectionsCapped = value;
    }

    public RelationToViewer getRelationToViewer() {
        return relationToViewer;
    }

    public void setRelationToViewer(RelationToViewer value) {
        this.relationToViewer = ((RelationToViewerImpl) value);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getPublicProfileUrl() {
        return publicProfileUrl;
    }

    public void setPublicProfileUrl(String value) {
        this.publicProfileUrl = value;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String value) {
        this.interests = value;
    }

    public String getAssociations() {
        return associations;
    }

    public void setAssociations(String value) {
        this.associations = value;
    }

    public String getHonors() {
        return honors;
    }

    public void setHonors(String value) {
        this.honors = value;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String value) {
        this.specialties = value;
    }

    public Certifications getCertifications() {
        return certifications;
    }

    public void setCertifications(Certifications value) {
        this.certifications = ((CertificationsImpl) value);
    }

    public Patents getPatents() {
        return patents;
    }

    public void setPatents(Patents value) {
        this.patents = ((PatentsImpl) value);
    }

    public Publications getPublications() {
        return publications;
    }

    public void setPublications(Publications value) {
        this.publications = ((PublicationsImpl) value);
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills value) {
        this.skills = ((SkillsImpl) value);
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages value) {
        this.languages = ((LanguagesImpl) value);
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions value) {
        this.positions = ((PositionsImpl) value);
    }

    public ThreeCurrentPositions getThreeCurrentPositions() {
        return threeCurrentPositions;
    }

    public void setThreeCurrentPositions(ThreeCurrentPositions value) {
        this.threeCurrentPositions = ((ThreeCurrentPositionsImpl) value);
    }

    public ThreePastPositions getThreePastPositions() {
        return threePastPositions;
    }

    public void setThreePastPositions(ThreePastPositions value) {
        this.threePastPositions = ((ThreePastPositionsImpl) value);
    }

    public Educations getEducations() {
        return educations;
    }

    public void setEducations(Educations value) {
        this.educations = ((EducationsImpl) value);
    }

    public MemberUrlResources getMemberUrlResources() {
        return memberUrlResources;
    }

    public void setMemberUrlResources(MemberUrlResources value) {
        this.memberUrlResources = ((MemberUrlResourcesImpl) value);
    }

    public ApiStandardProfileRequest getApiStandardProfileRequest() {
        return apiStandardProfileRequest;
    }

    public void setApiStandardProfileRequest(ApiStandardProfileRequest value) {
        this.apiStandardProfileRequest = ((ApiStandardProfileRequestImpl) value);
    }

    public SiteStandardProfileRequest getSiteStandardProfileRequest() {
        return siteStandardProfileRequest;
    }

    public void setSiteStandardProfileRequest(SiteStandardProfileRequest value) {
        this.siteStandardProfileRequest = ((SiteStandardProfileRequestImpl) value);
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String value) {
        this.pictureUrl = value;
    }

    public RecommendationsGiven getRecommendationsGiven() {
        return recommendationsGiven;
    }

    public void setRecommendationsGiven(RecommendationsGiven value) {
        this.recommendationsGiven = ((RecommendationsGivenImpl) value);
    }

    public RecommendationsReceived getRecommendationsReceived() {
        return recommendationsReceived;
    }

    public void setRecommendationsReceived(RecommendationsReceived value) {
        this.recommendationsReceived = ((RecommendationsReceivedImpl) value);
    }

    public MemberGroups getMemberGroups() {
        return memberGroups;
    }

    public void setMemberGroups(MemberGroups value) {
        this.memberGroups = ((MemberGroupsImpl) value);
    }

    public PersonActivities getPersonActivities() {
        return personActivities;
    }

    public void setPersonActivities(PersonActivities value) {
        this.personActivities = ((PersonActivitiesImpl) value);
    }

    public ImAccounts getImAccounts() {
        return imAccounts;
    }

    public void setImAccounts(ImAccounts value) {
        this.imAccounts = ((ImAccountsImpl) value);
    }

    public TwitterAccounts getTwitterAccounts() {
        return twitterAccounts;
    }

    public void setTwitterAccounts(TwitterAccounts value) {
        this.twitterAccounts = ((TwitterAccountsImpl) value);
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth value) {
        this.dateOfBirth = ((DateOfBirthImpl) value);
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String value) {
        this.mainAddress = value;
    }

    public PhoneNumbers getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumbers value) {
        this.phoneNumbers = ((PhoneNumbersImpl) value);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }

}
