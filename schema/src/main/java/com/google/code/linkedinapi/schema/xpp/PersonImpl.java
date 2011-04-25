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

package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

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

public class PersonImpl
    extends BaseSchemaEntity
    implements Person
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1783387499401345056L;
	protected String id;
    protected String firstName;
    protected String lastName;
    protected String headline;
    protected LocationImpl location;
    protected String industry;
    protected ConnectionsImpl connections;
    protected String currentStatus;
    protected CurrentShareImpl currentShare;
    protected Long distance;
    protected Long currentStatusTimestamp;
    protected Long numRecommenders;
    protected Long numConnections;
    protected Boolean numConnectionsCapped;
    protected RelationToViewerImpl relationToViewer;
    protected String summary;
    protected String publicProfileUrl;
    protected String interests;
    protected String associations;
    protected String honors;
    protected String specialties;
    protected CertificationsImpl certifications;
    protected PatentsImpl patents;
    protected PublicationsImpl publications;
    protected SkillsImpl skills;
    protected LanguagesImpl languages;
    protected PositionsImpl positions;
    protected ThreeCurrentPositionsImpl threeCurrentPositions;
    protected ThreePastPositionsImpl threePastPositions;
    protected EducationsImpl educations;
    protected MemberUrlResourcesImpl memberUrlResources;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;
    protected RecommendationsGivenImpl recommendationsGiven;
    protected RecommendationsReceivedImpl recommendationsReceived;
    protected MemberGroupsImpl memberGroups;
    protected PersonActivitiesImpl personActivities;
    protected ImAccountsImpl imAccounts;
    protected TwitterAccountsImpl twitterAccounts;
    protected DateOfBirthImpl dateOfBirth;
    protected String mainAddress;
    protected PhoneNumbersImpl phoneNumbers;
    
    protected String pictureUrl;
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
    
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String value) {
        this.pictureUrl = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setPath(XppUtils.getAttributeValueFromNode(parser, "path"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("first-name")) {
        		setFirstName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("last-name")) {
        		setLastName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("headline")) {
        		setHeadline(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("industry")) {
        		setIndustry(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("num-recommenders")) {
        		setNumRecommenders(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("num-connections")) {
        		setNumConnections(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("num-connections-capped")) {
        		setNumConnectionsCapped(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("distance")) {
        		setDistance(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("current-status")) {
        		setCurrentStatus(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("current-share")) { 
    			CurrentShareImpl currentShare = new CurrentShareImpl();
    			currentShare.init(parser);
    			setCurrentShare(currentShare);
        	} else if (name.equals("current-status-timestamp")) {
        		setCurrentStatusTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("picture-url")) {
        		setPictureUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("summary")) {
        		setSummary(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("public-profile-url")) {
        		setPublicProfileUrl(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("interests")) {
        		setInterests(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("associations")) {
        		setAssociations(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("honors")) {
        		setHonors(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("specialties")) { 
        		setSpecialties(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("main-address")) { 
        		setMainAddress(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("location")) { 
    			LocationImpl location = new LocationImpl();
    			location.init(parser);
    			setLocation(location);
        	} else if (name.equals("connections")) { 
    			ConnectionsImpl connections = new ConnectionsImpl();
    			connections.init(parser);
    			setConnections(connections);
        	} else if (name.equals("relation-to-viewer")) { 
    			RelationToViewerImpl relation = new RelationToViewerImpl();
    			relation.init(parser);
    			setRelationToViewer(relation);
        	} else if (name.equals("certifications")) { 
        		CertificationsImpl certifications = new CertificationsImpl();
    			certifications.init(parser);
    			setCertifications(certifications);
        	} else if (name.equals("patents")) { 
    			PatentsImpl patents = new PatentsImpl();
    			patents.init(parser);
    			setPatents(patents);
        	} else if (name.equals("publications")) { 
    			PublicationsImpl publications = new PublicationsImpl();
    			publications.init(parser);
    			setPublications(publications);
        	} else if (name.equals("skills")) { 
    			SkillsImpl skills = new SkillsImpl();
    			skills.init(parser);
    			setSkills(skills);
        	} else if (name.equals("languages")) { 
    			LanguagesImpl languages = new LanguagesImpl();
    			languages.init(parser);
    			setLanguages(languages);
        	} else if (name.equals("positions")) { 
    			PositionsImpl position = new PositionsImpl();
    			position.init(parser);
    			setPositions(position);
        	} else if (name.equals("three-current-positions")) { 
        		ThreeCurrentPositionsImpl position = new ThreeCurrentPositionsImpl();
    			position.init(parser);
    			setThreeCurrentPositions(position);
        	} else if (name.equals("three-past-positions")) { 
        		ThreePastPositionsImpl position = new ThreePastPositionsImpl();
    			position.init(parser);
    			setThreePastPositions(position);
        	} else if (name.equals("educations")) { 
    			EducationsImpl educations = new EducationsImpl();
    			educations.init(parser);
    			setEducations(educations);
        	} else if (name.equals("member-url-resources")) {
    			MemberUrlResourcesImpl memberUrl = new MemberUrlResourcesImpl();
    			memberUrl.init(parser);
    			setMemberUrlResources(memberUrl);
        	} else if (name.equals("api-standard-profile-request")) {
    			ApiStandardProfileRequestImpl apiRequest = new ApiStandardProfileRequestImpl();
    			apiRequest.init(parser);
    			setApiStandardProfileRequest(apiRequest);
        	} else if (name.equals("site-standard-profile-request")) {
    			SiteStandardProfileRequestImpl apiRequest = new SiteStandardProfileRequestImpl();
    			apiRequest.init(parser);
    			setSiteStandardProfileRequest(apiRequest);
        	} else if (name.equals("recommendations-given")) {
    			RecommendationsGivenImpl recommendation = new RecommendationsGivenImpl();
    			recommendation.init(parser);
    			setRecommendationsGiven(recommendation);
        	} else if (name.equals("recommendations-received")) {
    			RecommendationsReceivedImpl recommendation = new RecommendationsReceivedImpl();
    			recommendation.init(parser);
    			setRecommendationsReceived(recommendation);
        	} else if (name.equals("member-groups")) {
    			MemberGroupsImpl memberGroups = new MemberGroupsImpl();
    			memberGroups.init(parser);
    			setMemberGroups(memberGroups);
        	} else if (name.equals("person-activities")) {
    			PersonActivitiesImpl activities = new PersonActivitiesImpl();
    			activities.init(parser);
    			setPersonActivities(activities);
            } else if (name.equals("im-accounts")) {
    			ImAccountsImpl accounts = new ImAccountsImpl();
    			accounts.init(parser);
    			setImAccounts(accounts);
            } else if (name.equals("twitter-accounts")) {
    			TwitterAccountsImpl accounts = new TwitterAccountsImpl();
    			accounts.init(parser);
    			setTwitterAccounts(accounts);
            } else if (name.equals("phone-numbers")) {
    			PhoneNumbersImpl phoneNumbers = new PhoneNumbersImpl();
    			phoneNumbers.init(parser);
    			setPhoneNumbers(phoneNumbers);
            } else if (name.equals("date-of-birth")) {
    			DateOfBirthImpl dateOfBirth = new DateOfBirthImpl();
    			dateOfBirth.init(parser);
    			setDateOfBirth(dateOfBirth);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "person");
		XppUtils.setAttributeValueToNode(element, "path", getPath());
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "first-name", getFirstName());
		XppUtils.setElementValueToNode(element, "last-name", getLastName());
		XppUtils.setElementValueToNode(element, "headline", getHeadline());
		XppUtils.setElementValueToNode(element, "industry", getIndustry());
		XppUtils.setElementValueToNode(element, "num-recommenders", getNumRecommenders());
		XppUtils.setElementValueToNode(element, "num-connections", getNumConnections());
		XppUtils.setElementValueToNode(element, "num-connections-capped", isNumConnectionsCapped());
		XppUtils.setElementValueToNode(element, "distance", getDistance());
		XppUtils.setElementValueToNode(element, "current-status", getCurrentStatus());
		XppUtils.setElementValueToNode(element, "current-status-timestamp", getCurrentStatusTimestamp());
		XppUtils.setElementValueToNode(element, "picture-url", getPictureUrl());
		XppUtils.setElementValueToNode(element, "summary", getSummary());
		XppUtils.setElementValueToNode(element, "public-profile-url", getPublicProfileUrl());
		XppUtils.setElementValueToNode(element, "interests", getInterests());
		XppUtils.setElementValueToNode(element, "associations", getAssociations());
		XppUtils.setElementValueToNode(element, "honors", getHonors());
		XppUtils.setElementValueToNode(element, "specialties", getSpecialties());
		XppUtils.setElementValueToNode(element, "main-address", getMainAddress());
		if (getLocation() != null) {
			((LocationImpl) getLocation()).toXml(serializer);
		}
		if (getConnections() != null) {
			((ConnectionsImpl) getConnections()).toXml(serializer);
		}
		if (getCurrentShare() != null) {
			((CurrentShareImpl) getCurrentShare()).toXml(serializer);
		}
		if (getRelationToViewer() != null) {
			((RelationToViewerImpl) getRelationToViewer()).toXml(serializer);
		}
		if (getCertifications() != null) {
			((CertificationsImpl) getCertifications()).toXml(serializer);
		}
		if (getPatents() != null) {
			((PatentsImpl) getPatents()).toXml(serializer);
		}
		if (getPublications() != null) {
			((PublicationsImpl) getPublications()).toXml(serializer);
		}
		if (getSkills() != null) {
			((SkillsImpl) getSkills()).toXml(serializer);
		}
		if (getLanguages() != null) {
			((LanguagesImpl) getLanguages()).toXml(serializer);
		}
		if (getPositions() != null) {
			((PositionsImpl) getPositions()).toXml(serializer);
		}
		if (getThreeCurrentPositions() != null) {
			((ThreeCurrentPositionsImpl) getThreeCurrentPositions()).toXml(serializer);
		}
		if (getThreePastPositions() != null) {
			((ThreePastPositionsImpl) getThreePastPositions()).toXml(serializer);
		}
		if (getEducations() != null) {
			((EducationsImpl) getEducations()).toXml(serializer);
		}
		if (getMemberUrlResources() != null) {
			((MemberUrlResourcesImpl) getMemberUrlResources()).toXml(serializer);
		}
		if (getApiStandardProfileRequest() != null) {
			((ApiStandardProfileRequestImpl) getApiStandardProfileRequest()).toXml(serializer);
		}
		if (getSiteStandardProfileRequest() != null) {
			((SiteStandardProfileRequestImpl) getSiteStandardProfileRequest()).toXml(serializer);
		}
		if (getRecommendationsGiven() != null) {
			((RecommendationsGivenImpl) getRecommendationsGiven()).toXml(serializer);
		}
		if (getRecommendationsReceived() != null) {
			((RecommendationsReceivedImpl) getRecommendationsReceived()).toXml(serializer);
		}
		if (getMemberGroups() != null) {
			((MemberGroupsImpl) getMemberGroups()).toXml(serializer);
		}
		if (getPersonActivities() != null) {
			((PersonActivitiesImpl) getPersonActivities()).toXml(serializer);
		}
		if (getImAccounts() != null) {
			((ImAccountsImpl) getImAccounts()).toXml(serializer);
		}
		if (getTwitterAccounts() != null) {
			((TwitterAccountsImpl) getTwitterAccounts()).toXml(serializer);
		}
		if (getDateOfBirth() != null) {
			((DateOfBirthImpl) getDateOfBirth()).toXml(serializer);
		}
		if (getPhoneNumbers() != null) {
			((PhoneNumbersImpl) getPhoneNumbers()).toXml(serializer);
		}
		
		serializer.endTag(null, "person");
	}
}
