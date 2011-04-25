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
package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nabeel Mukhtar
 *
 */
public enum ProfileField implements CompositeEnum<ProfileField> {
	
    /**
     * the member token for this member
     */
    ID("id", null, true),

    /**
     * the member's first name
     */
    FIRST_NAME("first-name", null, true),

    /**
     * the member's last name
     */
    LAST_NAME("last-name", null, true),

    /**
     * the member's headline (often "Job Title at Company")
     */
    HEADLINE("headline", null, true),

    /**
     * Generic name of the location of the LinkedIn member, (ex: "San Francisco Bay Area")
     */
    LOCATION("location", null, true),
    
    /**
     * Generic name of the location of the LinkedIn member, (ex: "San Francisco Bay Area")
     */
    LOCATION_NAME("name", LOCATION, true),

    LOCATION_COUNTRY("country", LOCATION, true),
    
    /**
     * country code for the LinkedIn member
     */
//    LOCATION_COUNTRY_CODE("code", LOCATION_COUNTRY, true),

    /**
     * the industry the LinkedIn member has indicated their profile belongs to
     */
    INDUSTRY("industry", null, true),

    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    DISTANCE("distance", null, false),

    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    RELATION_TO_VIEWER("relation-to-viewer", null, false),
    
    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    RELATION_TO_VIEWER_DISTANCE("distance", RELATION_TO_VIEWER, false),

    RELATION_TO_VIEWER_RELATED_CONNECTIONS("related-connections", RELATION_TO_VIEWER, false),
    RELATION_TO_VIEWER_RELATED_CONNECTIONS_FIRST_NAME("first-name", RELATION_TO_VIEWER_RELATED_CONNECTIONS, false),
    RELATION_TO_VIEWER_RELATED_CONNECTIONS_LAST_NAME("last-name", RELATION_TO_VIEWER_RELATED_CONNECTIONS, false),
    RELATION_TO_VIEWER_RELATED_CONNECTIONS_PUBLIC_PROFILE_URL("public-profile-url", RELATION_TO_VIEWER_RELATED_CONNECTIONS, false),
    
    /**
     * a total attribute will denote the number of connections that link the fetching member to the fetched. Contains brief connection/person objects indicating the connecting first degree members.
     */
    RELATION_TO_VIEWER_CONNECTIONS("num-related-connections", RELATION_TO_VIEWER, false),

    /**
     * the member's current status, if set
     */
    CURRENT_STATUS("current-status", null, true),
    
    /**
     * the member's current share, if set
     */
    CURRENT_SHARE("current-share", null, true),

    /**
     * the timestamp, in milliseconds, when the member's status was last set
     */
    CURRENT_STATUS_TIMESTAMP("current-status-timestamp", null, true),

    /**
     * an empty collection, indicating the # of connections the member has with a total attribute.
     */
    CONNECTIONS("connections", null, false),
    
    NUM_CONNECTIONS("num-connections", null, true),
    
    NUM_CONNECTIONS_CAPPED("num-connections-capped", null, true),

    /**
     * A long-form text area where the member describes their professional profile
     */
    SUMMARY("summary", null, false),

    /**
     * A short-form text area where the member enumerates their specialties.
     */
    SPECIALTIES("specialties", null, false),

    /**
     * A short-form text area describing how the member approaches proposals
     */
    PROPOSAL_COMMENTS("proposal-comments", null, false),

    /**
     * A short-form text area enumerating the Associations a member has
     */
    ASSOCIATIONS("associations", null, false),

    /**
     * A short-form text area describing what Honors the member may have
     */
    
    HONORS("honors", null, false),

    INTERESTS("interests", null, false),
    
    /**
     * A collection of positions a member has had, the total indicated by a total attribute
     */
    POSITIONS("positions", null, true),
    
    POSITIONS_ID("id", POSITIONS, true),
    POSITIONS_TITLE("title", POSITIONS, true),
    POSITIONS_SUMMARY("summary", POSITIONS, true),
    POSITIONS_START_DATE("start-date", POSITIONS, true),
    POSITIONS_END_DATE("end-date", POSITIONS, true),
    POSITIONS_IS_CURRENT("is-current", POSITIONS, true),
    POSITIONS_COMPANY("company", POSITIONS, true),
    POSITIONS_COMPANY_NAME("name", POSITIONS_COMPANY, true),
    POSITIONS_COMPANY_TYPE("type", POSITIONS_COMPANY, true),
    POSITIONS_COMPANY_SIZE("size", POSITIONS_COMPANY, true),
    POSITIONS_COMPANY_INDUSTRY("industry", POSITIONS_COMPANY, true),
    POSITIONS_COMPANY_TICKER("ticker", POSITIONS_COMPANY, true),
    
    /**
     * A collection of publications authored by this member
     */
    PUBLICATIONS("publications", null, true),
    
    PUBLICATIONS_ID("id", PUBLICATIONS, true),
    PUBLICATIONS_TITLE("title", PUBLICATIONS, true),
    PUBLICATIONS_PUBLISHER("publisher", PUBLICATIONS, true),
    PUBLICATIONS_PUBLISHER_NAME("name", PUBLICATIONS_PUBLISHER, true),
    PUBLICATIONS_AUTHORS("authors", PUBLICATIONS, true),
    PUBLICATIONS_AUTHORS_ID("id", PUBLICATIONS_AUTHORS, true),
    PUBLICATIONS_AUTHORS_NAME("name", PUBLICATIONS_AUTHORS, true),
    PUBLICATIONS_AUTHORS_PERSON("person", PUBLICATIONS_AUTHORS, true),
    PUBLICATIONS_DATE("date", PUBLICATIONS, true),
    PUBLICATIONS_URL("url", PUBLICATIONS, true),
    PUBLICATIONS_SUMMARY("summary", PUBLICATIONS, true),

    /**
     * A collection of patents or patent applications held by this member
     */
    PATENTS("patents", null, true),
    
    PATENTS_ID("id", PATENTS, true),
    PATENTS_TITLE("title", PATENTS, true),
    PATENTS_NUMBER("number", PATENTS, true),
    PATENTS_DATE("date", PATENTS, true),
    PATENTS_URL("url", PATENTS, true),
    PATENTS_SUMMARY("summary", PATENTS, true),
    PATENTS_STATUS("status", PATENTS, true),
    PATENTS_STATUS_ID("id", PATENTS_STATUS, true),
    PATENTS_STATUS_NAME("name", PATENTS_STATUS, true),
    PATENTS_OFFICE("office", PATENTS, true),
    PATENTS_OFFICE_NAME("name", PATENTS_OFFICE, true),
    PATENTS_INVENTORS("inventors", PATENTS, true),
    PATENTS_INVENTORS_ID("id", PATENTS_INVENTORS, true),
    PATENTS_INVENTORS_NAME("name", PATENTS_INVENTORS, true),
    PATENTS_INVENTORS_PERSON("person", PATENTS_INVENTORS, true),

    /**
     * A collection of languages and the level of the member's proficiency for each
     */
    LANGUAGES("languages", null, true),
    
    LANGUAGES_ID("id", LANGUAGES, true),
    LANGUAGES_LANGUAGE("language", LANGUAGES, true),
    LANGUAGES_LANGUAGE_NAME("name", LANGUAGES_LANGUAGE, true),
    LANGUAGES_PROFICIENCY("proficiency", LANGUAGES, true),
    LANGUAGES_PROFICIENCY_LEVEL("level", LANGUAGES_PROFICIENCY, true),
    LANGUAGES_PROFICIENCY_NAME("name", LANGUAGES_PROFICIENCY, true),

    /**
     * A collection of skills held by this member
     */
    SKILLS("skills", null, true),

    SKILLS_ID("id", SKILLS, true),
    SKILLS_SKILL("skill", SKILLS, true),
    SKILLS_SKILL_NAME("name", SKILLS_SKILL, true),
    SKILLS_PROFICIENCY("proficiency", SKILLS, true),
    SKILLS_PROFICIENCY_LEVEL("level", SKILLS_PROFICIENCY, true),
    SKILLS_PROFICIENCY_NAME("name", SKILLS_PROFICIENCY, true),
    SKILLS_YEARS("years", SKILLS, true),
    SKILLS_YEARS_ID("id", SKILLS_YEARS, true),
    SKILLS_YEARS_NAME("name", SKILLS_YEARS, true),
    
    /**
     * A collection of certifications earned by this member
     */
    CERTIFICATIONS("certifications", null, true),
    
    CERTIFICATIONS_ID("id", CERTIFICATIONS, true),
    CERTIFICATIONS_NAME("name", CERTIFICATIONS, true),
    CERTIFICATIONS_AUTHORITY("authority", CERTIFICATIONS, true),
    CERTIFICATIONS_AUTHORITY_NAME("name", CERTIFICATIONS_AUTHORITY, true),
    CERTIFICATIONS_NUMBER("number", CERTIFICATIONS, true),
    CERTIFICATIONS_START_DATE("start-date", CERTIFICATIONS, true),
    CERTIFICATIONS_END_DATE("end-date", CERTIFICATIONS, true),
    
    /**
     * A collection of education institutions a member has attended, the total indicated by a total attribute
     */
    EDUCATIONS("educations", null, true),
    EDUCATIONS_ID("id", EDUCATIONS, true),
    EDUCATIONS_SCHOOL_NAME("school-name", EDUCATIONS, true),
    EDUCATIONS_FIELD_OF_STUDY("field-of-study", EDUCATIONS, true),
    EDUCATIONS_START_DATE("start-date", EDUCATIONS, true),
    EDUCATIONS_END_DATE("end-date", EDUCATIONS, true),
    EDUCATIONS_DEGREE("degree", EDUCATIONS, true),
    EDUCATIONS_ACTIVITIES("activities", EDUCATIONS, true),
    EDUCATIONS_NOTES("notes", EDUCATIONS, true),

    /**
     * A collection of positions a member currently holds, limited to three and indicated by a total attribute
     */
    THREE_CURRENT_POSITIONS("three-current-positions", null, true),
    
    /**
     * A collection of positions a member formerly held, limited to the three most recent and indicated by a total attribute
     */
    THREE_PAST_POSITIONS("three-past-positions", null, true),
    
    NUM_RECOMMENDERS("num-recommenders", null, false),
    
    RECOMMENDATIONS_RECEIVED("recommendations-received", null, true),
    
    RECOMMENDATIONS_RECEIVED_ID("id", RECOMMENDATIONS_RECEIVED, true),
    RECOMMENDATIONS_RECEIVED_RECOMMENDATION_TYPE("recommendation-type", RECOMMENDATIONS_RECEIVED, true),
    RECOMMENDATIONS_RECEIVED_RECOMMENDER("recommender", RECOMMENDATIONS_RECEIVED, true),
    
    /**
     * a collection of phone numbers
     */
    PHONE_NUMBERS("phone-numbers", null, true),
    
    /**
     * a collection of instant messenger accounts
     */
    IM_ACCOUNTS("im-accounts", null, true),

    /**
     * a collection of twitter accounts
     */
    TWITTER_ACCOUNTS("twitter-accounts", null, true),

    /**
     * member's birth date
     */
    DATE_OF_BIRTH("date-of-birth", null, true),

    /**
     * address
     */
    MAIN_ADDRESS("main-address", null, true),
    
    /**
     * A collection of URLs the member has chosen to share on their LinkedIn profile
     */
    MEMBER_URL_RESOURCES("member-url-resources", null, true),

//    MEMBER_URL("member-url", null, true),
    
    /**
     * The fully-qualified URL being shared
     */
    MEMBER_URL_URL("url", MEMBER_URL_RESOURCES, false),

    /**
     * The label given to the URL by the member
     */
    MEMBER_URL_NAME("name", MEMBER_URL_RESOURCES, false),
    
    /**
     * A URL to the profile picture, if the member has associated one with their profile and it is visible to the requestor
     */
    PICTURE_URL("picture-url", null, true),

    /**
     * the URL to the member's authenticated profile on LinkedIn (requires a login to be viewed, unlike public profiles)
     */
    SITE_STANDARD_PROFILE_REQUEST("site-standard-profile-request", null, true),
    
    SITE_STANDARD_PROFILE_REQUEST_URL("url", SITE_STANDARD_PROFILE_REQUEST, true),
    

    /**
     * An URL representing the resource you would request for programmatic access to the member's public profile
     */
//    API_PUBLIC_PROFILE_REQUEST("api-public-profile-request", null, true),
    
//    API_PUBLIC_PROFILE_REQUEST_URL("url", API_PUBLIC_PROFILE_REQUEST, true),
    
    /**
     * An URL representing the resource you would request for programmatic access to the member's public profile
     */
//    SITE_PUBLIC_PROFILE_REQUEST("site-public-profile-request", null, true),
    
//    SITE_PUBLIC_PROFILE_REQUEST_URL("url", SITE_PUBLIC_PROFILE_REQUEST, true),

    /**
     * An URL representing the resource you would request for programmatic access to the member's profile
     */
    API_STANDARD_PROFILE_REQUEST("api-standard-profile-request", null, true),
    
    API_STANDARD_PROFILE_REQUEST_URL("url", API_STANDARD_PROFILE_REQUEST, true),
    
    /**
     * A collection of fields that can be re-used as HTTP headers to request an out of network profile programmatically
     */
    API_STANDARD_PROFILE_REQUEST_HEADERS("headers", API_STANDARD_PROFILE_REQUEST, true),

    /**
     * 	A URL to the member's public profile, if enabled.
     */
    PUBLIC_PROFILE_URL("public-profile-url", null, true);
    
    
	public enum Scope {
		User, Connections, All;
	}
    
    /**
     * Field Description.
     */
	private static final Map<String, ProfileField> stringToEnum = new HashMap<String, ProfileField>();

	static { // Initialize map from constant name to enum constant
		for (ProfileField op : values()) {
			stringToEnum.put(op.fieldName(), op);
		}
	}
    
    /** Field description */
    private final String fieldName;
    
    private final ProfileField parent;

    /** Field description */
    private final boolean availableForConnections;
    
    /**
     * Constructs ...
     *
     *
     * @param name
     */
    ProfileField(String name, ProfileField parent, boolean availableForConnections) {
        this.fieldName = name;
        this.parent = parent;
        this.availableForConnections = availableForConnections;
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.client.enumeration.FieldEnum#fieldName()
	 */
    public String fieldName() {
        return this.fieldName;
    }

    /** 
	 * 
	 */
    public boolean isAvailableForConnections() {
        return this.availableForConnections;
    }
    
    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

	/**
	 *
	 * @return Returns ProfileField for string, or null if string is invalid
	 */
	public static FieldEnum fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
	
	/**
	 *
	 * @return Returns ProfileFields available for connections.
	 */
	public static Set<ProfileField> valuesForConnections() {
		final Set<ProfileField> valuesForConnections = new HashSet<ProfileField>();
		for (ProfileField field : values()) {
			if (field.isAvailableForConnections()) {
				valuesForConnections.add(field);
			}
		}
		return valuesForConnections;
	}

	@Override
	public ProfileField parent() {
		return parent;
	}
}
