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

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.Answer;
import com.google.code.linkedinapi.schema.Answers;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Application;
import com.google.code.linkedinapi.schema.Attribution;
import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Bucket;
import com.google.code.linkedinapi.schema.Buckets;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Content;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.CurrentShare;
import com.google.code.linkedinapi.schema.DateOfBirth;
import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.Error;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.HttpHeader;
import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccountType;
import com.google.code.linkedinapi.schema.ImAccounts;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;
import com.google.code.linkedinapi.schema.ItemContent;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobPoster;
import com.google.code.linkedinapi.schema.Like;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.MemberGroups;
import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.PersonActivities;
import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneNumbers;
import com.google.code.linkedinapi.schema.PhoneType;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.Property;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.QuestionCategories;
import com.google.code.linkedinapi.schema.QuestionCategory;
import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.Recipients;
import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationsGiven;
import com.google.code.linkedinapi.schema.RecommendationsReceived;
import com.google.code.linkedinapi.schema.Recommendee;
import com.google.code.linkedinapi.schema.Recommender;
import com.google.code.linkedinapi.schema.RelatedConnections;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.ServiceProvider;
import com.google.code.linkedinapi.schema.Share;
import com.google.code.linkedinapi.schema.SiteGroupRequest;
import com.google.code.linkedinapi.schema.SiteJobRequest;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;
import com.google.code.linkedinapi.schema.Source;
import com.google.code.linkedinapi.schema.StartDate;
import com.google.code.linkedinapi.schema.ThreeCurrentPositions;
import com.google.code.linkedinapi.schema.ThreePastPositions;
import com.google.code.linkedinapi.schema.TwitterAccount;
import com.google.code.linkedinapi.schema.TwitterAccounts;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.UpdateContent;
import com.google.code.linkedinapi.schema.Updates;
import com.google.code.linkedinapi.schema.Visibility;

/**
 * A factory for creating DomElement objects.
 */
public class XppElementFactory implements SchemaElementFactory<String> {

	private static XmlPullParserFactory XML_SERIALIZER_FACTORY;

	/** The static logger. */
	private static final Logger LOG = Logger.getLogger(XppElementFactory.class
			.getCanonicalName());

	private final static String _Summary_QNAME = "summary";
	private final static String _Body_QNAME = "body";
	private final static String _Honors_QNAME = "honors";
	private final static String _Count_QNAME = "count";
	private final static String _PublicProfileUrl_QNAME = "public-profile-url";
	private final static String _IsLikable_QNAME = "is-likable";
	private final static String _CurrentStatus_QNAME = "current-status";
	private final static String _IsCommentable_QNAME = "is-commentable";
	private final static String _MainAddress_QNAME = "main-address";
	private final static String _ErrorCode_QNAME = "error-code";
	private final static String _CurrentStatusTimestamp_QNAME = "current-status-timestamp";
	private final static String _Type_QNAME = "type";
	private final static String _NumRecommenders_QNAME = "num-recommenders";
	private final static String _ProviderAccountName_QNAME = "provider-account-name";
	private final static String _ThumbnailUrl_QNAME = "thumbnail-url";
	private final static String _ConnectType_QNAME = "connect-type";
	private final static String _Specialties_QNAME = "specialties";
	private final static String _Value_QNAME = "value";
	private final static String _WebUrl_QNAME = "web-url";
	private final static String _Year_QNAME = "year";
	private final static String _LastName_QNAME = "last-name";
	private final static String _Activities_QNAME = "activities";
	private final static String _Industry_QNAME = "industry";
	private final static String _ImAccountName_QNAME = "im-account-name";
	private final static String _SubmittedImageUrl_QNAME = "submitted-image-url";
	private final static String _ProviderAccountId_QNAME = "provider-account-id";
	private final static String _SubmittedUrl_QNAME = "submitted-url";
	private final static String _Code_QNAME = "code";
	private final static String _ShortenedUrl_QNAME = "shortened-url";
	private final static String _Url_QNAME = "url";
	private final static String _RecommendationText_QNAME = "recommendation-text";
	private final static String _Associations_QNAME = "associations";
	private final static String _Month_QNAME = "month";
	private final static String _Day_QNAME = "day";
	private final static String _Comment_QNAME = "comment";
	private final static String _PictureUrl_QNAME = "picture-url";
	private final static String _Headline_QNAME = "headline";
	private final static String _ContentType_QNAME = "content-type";
	private final static String _Interests_QNAME = "interests";
	private final static String _NumResults_QNAME = "num-results";
	private final static String _Subject_QNAME = "subject";
	private final static String _IsCurrent_QNAME = "is-current";
	private final static String _IsLiked_QNAME = "is-liked";
	private final static String _NumLikes_QNAME = "num-likes";
	private final static String _Id_QNAME = "id";
	private final static String _Timestamp_QNAME = "timestamp";
	private final static String _Distance_QNAME = "distance";
	private final static String _Title_QNAME = "title";
	private final static String _ImAccountType_QNAME = "im-account-type";
	private final static String _Name_QNAME = "name";
	private final static String _RecommendationSnippet_QNAME = "recommendation-snippet";
	private final static String _NumConnectionsCapped_QNAME = "num-connections-capped";
	private final static String _AppId_QNAME = "app-id";
	private final static String _SchoolName_QNAME = "school-name";
	private final static String _UpdateType_QNAME = "update-type";
	private final static String _UpdateKey_QNAME = "update-key";
	private final static String _Message_QNAME = "message";
	private final static String _PhoneType_QNAME = "phone-type";
	private final static String _Degree_QNAME = "degree";
	private final static String _FirstName_QNAME = "first-name";
	private final static String _SequenceNumber_QNAME = "sequence-number";
	private final static String _NumConnections_QNAME = "num-connections";
	private final static String _FieldOfStudy_QNAME = "field-of-study";
	private final static String _Notes_QNAME = "notes";

	static {
		try {
			XML_SERIALIZER_FACTORY = XmlPullParserFactory.newInstance();
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					"An error occurred while creating pull parser factory.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createAuthorization()
	 */
	public Authorization createAuthorization() {
		return new AuthorizationImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createCompany()
	 */
	public Company createCompany() {
		return new CompanyImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createRecipient()
	 */
	public Recipient createRecipient() {
		return new RecipientImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPeople()
	 */
	public People createPeople() {
		return new PeopleImpl();
	}
	public RelatedConnections createRelatedConnections() {
		return new RelatedConnectionsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createMailboxItem()
	 */
	public MailboxItem createMailboxItem() {
		return new MailboxItemImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createActivity()
	 */
	public Activity createActivity() {
		return new ActivityImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPosition()
	 */
	public Position createPosition() {
		return new PositionImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createCountry()
	 */
	public Country createCountry() {
		return new CountryImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createMemberUrlResources()
	 */
	public MemberUrlResources createMemberUrlResources() {
		return new MemberUrlResourcesImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createApiStandardProfileRequest()
	 */
	public ApiStandardProfileRequest createApiStandardProfileRequest() {
		return new ApiStandardProfileRequestImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createLocation()
	 */
	public Location createLocation() {
		return new LocationImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createInvitationRequest()
	 */
	public InvitationRequest createInvitationRequest() {
		return new InvitationRequestImpl();
	}

	/**
	 * Create an instance of {@link UpdateComments }
	 * 
	 */
	public UpdateComments createUpdateComments() {
		return new UpdateCommentsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdate()
	 */
	public Update createUpdate() {
		return new UpdateImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdateContent()
	 */
	public UpdateContent createUpdateContent() {
		return new UpdateContentImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createMemberUrl()
	 */
	public MemberUrl createMemberUrl() {
		return new MemberUrlImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createNetwork()
	 */
	public Network createNetwork() {
		return new NetworkImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createHeaders()
	 */
	public Headers createHeaders() {
		return new HeadersImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPerson()
	 */
	public Person createPerson() {
		return new PersonImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createNetworkStats()
	 */
	public NetworkStats createNetworkStats() {
		return new NetworkStatsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createProperty()
	 */
	public Property createProperty() {
		return new PropertyImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPositions()
	 */
	public Positions createPositions() {
		return new PositionsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createEducation()
	 */
	public Education createEducation() {
		return new EducationImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdateComment()
	 */
	public UpdateComment createUpdateComment() {
		return new UpdateCommentImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdates()
	 */
	public Updates createUpdates() {
		return new UpdatesImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createError()
	 */
	public Error createError() {
		return new ErrorImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createConnections()
	 */
	public Connections createConnections() {
		return new ConnectionsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createItemContent()
	 */
	public ItemContent createItemContent() {
		return new ItemContentImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createRecipients()
	 */
	public Recipients createRecipients() {
		return new RecipientsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createStartDate()
	 */
	public StartDate createStartDate() {
		return new StartDateImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createRelationToViewer()
	 */
	public RelationToViewer createRelationToViewer() {
		return new RelationToViewerImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createHttpHeader()
	 */
	public HttpHeader createHttpHeader() {
		return new HttpHeaderImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createEducations()
	 */
	public Educations createEducations() {
		return new EducationsImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createEndDate()
	 */
	@Override
	public EndDate createEndDate() {
		return new EndDateImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createSiteStandardProfileRequest()
	 */
	@Override
	public SiteStandardProfileRequest createSiteStandardProfileRequest() {
		return new SiteStandardProfileRequestImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createContentType(com.google.code.linkedinapi.schema.NetworkUpdateContentType)
	 */
	public String createContentType(NetworkUpdateContentType value) {
		return createElement(_ContentType_QNAME,
				NetworkUpdateContentType.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHeadline(java.lang.String)
	 */
	public String createHeadline(String value) {
		return createElement(_Headline_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSummary(java.lang.String)
	 */
	public String createSummary(String value) {
		return createElement(_Summary_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createBody(java.lang.String)
	 */
	public String createBody(String value) {
		return createElement(_Body_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSubject(java.lang.String)
	 */
	public String createSubject(String value) {
		return createElement(_Subject_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCurrentStatus(java.lang.String)
	 */
	public String createCurrentStatus(String value) {
		return createElement(_CurrentStatus_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIsCommentable(java.lang.Boolean)
	 */
	public String createIsCommentable(Boolean value) {
		return createElement(_IsCommentable_QNAME, Boolean.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createErrorCode(java.lang.String)
	 */
	public String createErrorCode(String value) {
		return createElement(_ErrorCode_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCurrentStatusTimestamp(java.lang.Long)
	 */
	public String createCurrentStatusTimestamp(Long value) {
		return createElement(_CurrentStatusTimestamp_QNAME, Long.class, null,
				value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createType(java.lang.String)
	 */
	public String createType(String value) {
		return createElement(_Type_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNumRecommenders(java.lang.Long)
	 */
	public String createNumRecommenders(Long value) {
		return createElement(_NumRecommenders_QNAME, Long.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIsCurrent(java.lang.Boolean)
	 */
	public String createIsCurrent(Boolean value) {
		return createElement(_IsCurrent_QNAME, Boolean.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createTimestamp(java.lang.Long)
	 */
	public String createTimestamp(Long value) {
		return createElement(_Timestamp_QNAME, Long.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createId(java.lang.String)
	 */
	public String createId(String value) {
		return createElement(_Id_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createConnectType(com.google.code.linkedinapi.schema.InviteConnectType)
	 */
	public String createConnectType(InviteConnectType value) {
		return createElement(_ConnectType_QNAME, InviteConnectType.class, null,
				value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createDistance(java.lang.Long)
	 */
	public String createDistance(Long value) {
		return createElement(_Distance_QNAME, Long.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createTitle(java.lang.String)
	 */
	public String createTitle(String value) {
		return createElement(_Title_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createName(java.lang.String)
	 */
	public String createName(String value) {
		return createElement(_Name_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createValue(java.lang.String)
	 */
	public String createValue(String value) {
		return createElement(_Value_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createYear(java.lang.Long)
	 */
	public String createYear(Long value) {
		return createElement(_Year_QNAME, Long.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createLastName(java.lang.String)
	 */
	public String createLastName(String value) {
		return createElement(_LastName_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIndustry(java.lang.String)
	 */
	public String createIndustry(String value) {
		return createElement(_Industry_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSchoolName(java.lang.String)
	 */
	public String createSchoolName(String value) {
		return createElement(_SchoolName_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateType(com.google.code.linkedinapi.schema.NetworkUpdateReturnType)
	 */
	public String createUpdateType(NetworkUpdateReturnType value) {
		return createElement(_UpdateType_QNAME, NetworkUpdateReturnType.class,
				null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCode(java.lang.String)
	 */
	public String createCode(String value) {
		return createElement(_Code_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUrl(java.lang.String)
	 */
	public String createUrl(String value) {
		return createElement(_Url_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateKey(java.lang.String)
	 */
	public String createUpdateKey(String value) {
		return createElement(_UpdateKey_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMessage(java.lang.String)
	 */
	public String createMessage(String value) {
		return createElement(_Message_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createDegree(java.lang.String)
	 */
	public String createDegree(String value) {
		return createElement(_Degree_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createFirstName(java.lang.String)
	 */
	public String createFirstName(String value) {
		return createElement(_FirstName_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMonth(java.lang.Long)
	 */
	public String createMonth(Long value) {
		return createElement(_Month_QNAME, Long.class, null, value);
	}

	public String createSequenceNumber(Long value) {
		return createElement(_SequenceNumber_QNAME, Long.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createComment(java.lang.String)
	 */
	public String createComment(String value) {
		return createElement(_Comment_QNAME, String.class, null, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPictureUrl(java.lang.String)
	 */
	public String createPictureUrl(String value) {
		return createElement(_PictureUrl_QNAME, String.class, null, value);
	}

	public String createHonors(String value) {
		return createElement(_Honors_QNAME, String.class, null, value);
	}

	public String createInterests(String value) {
		return createElement(_Interests_QNAME, String.class, null, value);
	}

	public String createSpecialties(String value) {
		return createElement(_Specialties_QNAME, String.class, null, value);
	}

	public String createAssociations(String value) {
		return createElement(_Associations_QNAME, String.class, null, value);
	}

	/**
	 * Creates a new DomElement object.
	 * 
	 * @param contentType_QNAME
	 *            the content type_ qname
	 * @param class1
	 *            the class1
	 * @param object
	 *            the object
	 * @param value
	 *            the value
	 * 
	 * @return the element
	 */
	private String createElement(String contentType_QNAME, Class<?> class1,
			Object object, Object value) {
		if (value != null) {
			StringWriter writer = new StringWriter();
			try {
				XmlSerializer serializer = XML_SERIALIZER_FACTORY
						.newSerializer();
				serializer.setOutput(writer);
				serializer = serializer.startTag(null, contentType_QNAME);
				if (class1.equals(InviteConnectType.class)) {
					XppUtils.setElementValue(serializer,
							((InviteConnectType) value).value());
				} else if (class1.equals(NetworkUpdateReturnType.class)) {
					XppUtils.setElementValue(serializer,
							((NetworkUpdateReturnType) value).value());
				} else if (class1.equals(NetworkUpdateContentType.class)) {
					XppUtils.setElementValue(serializer,
							((NetworkUpdateContentType) value).value());
				} else {
					XppUtils.setElementValue(serializer, String.valueOf(value));
				}
				serializer.endTag(null, contentType_QNAME);
				serializer.flush();
			} catch (Exception e) {
				LOG.log(Level.SEVERE,
						"An error occurred while creating xml content.", e);
			}
			return writer.toString();
		} else {
			return null;
		}
	}

	@Override
	public Bucket createBucket() {

		return new BucketImpl();
	}

	@Override
	public Buckets createBuckets() {

		return new BucketsImpl();
	}

	@Override
	public Facet createFacet() {

		return new FacetImpl();
	}

	@Override
	public Facets createFacets() {

		return new FacetsImpl();
	}

	@Override
	public String createActivities(String value) {
		return createElement(_Activities_QNAME, String.class, null, value);
	}

	@Override
	public Answer createAnswer() {

		return new AnswerImpl();
	}

	@Override
	public Answers createAnswers() {

		return new AnswersImpl();
	}

	@Override
	public String createAppId(String value) {

		return createElement(_AppId_QNAME, String.class, null, value);
	}

	@Override
	public Application createApplication() {

		return new ApplicationImpl();
	}

	@Override
	public Attribution createAttribution() {

		return new AttributionImpl();
	}

	@Override
	public Author createAuthor() {

		return new AuthorImpl();
	}

	@Override
	public Content createContent() {

		return new ContentImpl();
	}

	@Override
	public String createCount(Long value) {

		return createElement(_Count_QNAME, String.class, null, value);
	}

	@Override
	public CurrentShare createCurrentShare() {

		return new CurrentShareImpl();
	}

	@Override
	public DateOfBirth createDateOfBirth() {

		return new DateOfBirthImpl();
	}

	@Override
	public String createDay(Long value) {

		return createElement(_Day_QNAME, String.class, null, value);
	}

	@Override
	public String createFieldOfStudy(String value) {

		return createElement(_FieldOfStudy_QNAME, String.class, null, value);
	}

	@Override
	public ImAccount createImAccount() {

		return new ImAccountImpl();
	}

	@Override
	public String createImAccountName(String value) {

		return createElement(_ImAccountName_QNAME, String.class, null, value);
	}

	@Override
	public String createImAccountType(ImAccountType value) {

		return createElement(_ImAccountType_QNAME, String.class, null, value);
	}

	@Override
	public ImAccounts createImAccounts() {

		return new ImAccountsImpl();
	}

	@Override
	public String createIsLikable(Boolean value) {

		return createElement(_IsLikable_QNAME, String.class, null, value);
	}

	@Override
	public String createIsLiked(Boolean value) {

		return createElement(_IsLiked_QNAME, String.class, null, value);
	}

	@Override
	public Job createJob() {
		return new JobImpl();
	}

	@Override
	public JobPoster createJobPoster() {
		return new JobPosterImpl();
	}

	@Override
	public Like createLike() {

		return new LikeImpl();
	}

	@Override
	public Likes createLikes() {

		return new LikesImpl();
	}

	@Override
	public String createMainAddress(String value) {

		return createElement(_MainAddress_QNAME, String.class, null, value);
	}

	@Override
	public MemberGroup createMemberGroup() {

		return new MemberGroupImpl();
	}

	@Override
	public MemberGroups createMemberGroups() {

		return new MemberGroupsImpl();
	}

	@Override
	public String createNotes(String value) {

		return createElement(_Notes_QNAME, String.class, null, value);
	}

	@Override
	public String createNumConnections(Long value) {

		return createElement(_NumConnections_QNAME, String.class, null, value);
	}

	@Override
	public String createNumConnectionsCapped(Boolean value) {

		return createElement(_NumConnectionsCapped_QNAME, String.class, null,
				value);
	}

	@Override
	public String createNumLikes(Long value) {

		return createElement(_NumLikes_QNAME, String.class, null, value);
	}

	@Override
	public String createNumResults(Long value) {

		return createElement(_NumResults_QNAME, String.class, null, value);
	}

	@Override
	public PeopleSearch createPeopleSearch() {

		return new PeopleSearchImpl();
	}

	@Override
	public PersonActivities createPersonActivities() {

		return new PersonActivitiesImpl();
	}

	@Override
	public PhoneNumber createPhoneNumber() {

		return new PhoneNumberImpl();
	}

	@Override
	public PhoneNumbers createPhoneNumbers() {

		return new PhoneNumbersImpl();
	}

	@Override
	public String createPhoneType(PhoneType value) {

		return createElement(_PhoneType_QNAME, String.class, null, value);
	}

	@Override
	public String createProviderAccountId(Long value) {

		return createElement(_ProviderAccountId_QNAME, String.class, null,
				value);
	}

	@Override
	public String createProviderAccountName(String value) {

		return createElement(_ProviderAccountName_QNAME, String.class, null,
				value);
	}

	@Override
	public String createPublicProfileUrl(String value) {

		return createElement(_PublicProfileUrl_QNAME, String.class, null, value);
	}

	@Override
	public Question createQuestion() {

		return new QuestionImpl();
	}

	@Override
	public QuestionCategories createQuestionCategories() {

		return new QuestionCategoriesImpl();
	}

	@Override
	public QuestionCategory createQuestionCategory() {

		return new QuestionCategoryImpl();
	}

	@Override
	public Recommendation createRecommendation() {

		return new RecommendationImpl();
	}

	@Override
	public String createRecommendationSnippet(String value) {

		return createElement(_RecommendationSnippet_QNAME, String.class, null,
				value);
	}

	@Override
	public String createRecommendationText(String value) {

		return createElement(_RecommendationText_QNAME, String.class, null,
				value);
	}

	@Override
	public RecommendationsGiven createRecommendationsGiven() {

		return new RecommendationsGivenImpl();
	}

	@Override
	public RecommendationsReceived createRecommendationsReceived() {

		return new RecommendationsReceivedImpl();
	}

	@Override
	public Recommendee createRecommendee() {

		return new RecommendeeImpl();
	}

	@Override
	public Recommender createRecommender() {

		return new RecommenderImpl();
	}

	@Override
	public ServiceProvider createServiceProvider() {

		return new ServiceProviderImpl();
	}

	@Override
	public Share createShare() {

		return new ShareImpl();
	}

	@Override
	public String createShortenedUrl(String value) {

		return createElement(_ShortenedUrl_QNAME, String.class, null, value);
	}

	@Override
	public SiteGroupRequest createSiteGroupRequest() {

		return new SiteGroupRequestImpl();
	}

	@Override
	public SiteJobRequest createSiteJobRequest() {

		return new SiteJobRequestImpl();
	}

	@Override
	public Source createSource() {

		return new SourceImpl();
	}

	@Override
	public String createSubmittedImageUrl(String value) {

		return createElement(_SubmittedImageUrl_QNAME, String.class, null,
				value);
	}

	@Override
	public String createSubmittedUrl(String value) {

		return createElement(_SubmittedUrl_QNAME, String.class, null, value);
	}

	@Override
	public ThreeCurrentPositions createThreeCurrentPositions() {

		return new ThreeCurrentPositionsImpl();
	}

	@Override
	public ThreePastPositions createThreePastPositions() {

		return new ThreePastPositionsImpl();
	}

	@Override
	public String createThumbnailUrl(String value) {

		return createElement(_ThumbnailUrl_QNAME, String.class, null, value);
	}

	@Override
	public TwitterAccount createTwitterAccount() {

		return new TwitterAccountImpl();
	}

	@Override
	public TwitterAccounts createTwitterAccounts() {

		return new TwitterAccountsImpl();
	}

	@Override
	public Visibility createVisibility() {

		return new VisibilityImpl();
	}

	@Override
	public String createWebUrl(String value) {

		return createElement(_WebUrl_QNAME, String.class, null, value);
	}
}
