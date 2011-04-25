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
package com.google.code.linkedinapi.client;

import java.util.EnumSet;
import java.util.concurrent.Future;

import org.junit.Test;

import com.google.code.linkedinapi.client.constant.TestConstants;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComments;

/**
 * @author Nabeel Mukhtar
 *
 */
public class AsyncLinkedInApiClientTest extends LinkedInApiClientTest {
	private AsyncLinkedInApiClient client;
	
	/** 
	 * @see com.google.code.linkedinapi.client.LinkedInApiClientTest#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createAsyncLinkedInApiClient(accessToken);
	}

	/**
	 * @see com.google.code.linkedinapi.client.LinkedInApiClientTest#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		client = null;
	}

//	/**
//	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsByEmail(java.lang.String)}.
//	 */
//	@Test
//	public void testGetConnectionsByEmailString() {
//		final String email = TestConstants.LINKED_IN_TEST_EMAIL;
//		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Email"), email);
//		Future<Connections> connections = client.getConnectionsByEmail(email);
//		assertNotNull("Connections should never be null.", connections);
//	}

//	/**
//	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsByEmail(java.lang.String, java.util.Set)}.
//	 */
//	@Test
//	public void testGetConnectionsByEmailStringSetOfProfileField() {
//		final String email = TestConstants.LINKED_IN_TEST_EMAIL;
//		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Email"), email);
//		Future<Connections> connections = client.getConnectionsByEmail(email, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
//		assertNotNull("Connections should never be null.", connections);
//	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsById(java.lang.String)}.
	 */
	@Test
	public void testGetConnectionsByIdString() {
		final String id = TestConstants.LINKED_IN_TEST_ID;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "ID"), id);
		Future<Connections> connections = client.getConnectionsById(id);
		assertNotNull("Connections should never be null.", connections);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsById(java.lang.String, java.util.Set)}.
	 */
	@Test
	public void testGetConnectionsByIdStringSetOfProfileField() {
		final String id = TestConstants.LINKED_IN_TEST_ID;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "ID"), id);
		Future<Connections> connections = client.getConnectionsById(id, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
		assertNotNull("Connections should never be null.", connections);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsByUrl(java.lang.String)}.
	 */
	@Test
	public void testGetConnectionsByUrlString() {
		final String url = TestConstants.LINKED_IN_TEST_URL;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "URL"), url);
		Future<Connections> connections = client.getConnectionsByUrl(url);
		assertNotNull("Connections should never be null.", connections);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsByUrl(java.lang.String, java.util.Set)}.
	 */
	@Test
	public void testGetConnectionsByUrlStringSetOfProfileField() {
		final String url = TestConstants.LINKED_IN_TEST_URL;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "URL"), url);
		Future<Connections> connections = client.getConnectionsByUrl(url, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
		assertNotNull("Connections should never be null.", connections);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsForCurrentUser()}.
	 */
	@Test
	public void testGetConnectionsForCurrentUser() {
		Future<Connections> connections = client.getConnectionsForCurrentUser();
		assertNotNull("Connections should never be null.", connections);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getConnectionsForCurrentUser(java.util.Set)}.
	 */
	@Test
	public void testGetConnectionsForCurrentUserSetOfProfileField() {
		Future<Connections> connections = client.getConnectionsForCurrentUser(EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
		assertNotNull("Connections should never be null.", connections);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates()}.
	 */
	@Test
	public void testGetNetworkUpdates() {
		Future<Network> network = client.getNetworkUpdates();
		assertNotNull("Network Updates should never be null.", network);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates(int, int)}.
	 */
	@Test
	public void testGetNetworkUpdatesIntInt() {
		Future<Network> network = client.getNetworkUpdates(1, 5);
		assertNotNull("Network Updates should never be null.", network);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates(java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testGetNetworkUpdatesDateDate() {
		Future<Network> network = client.getNetworkUpdates(getLastWeekDate(), getCurrentDate());
		assertNotNull("Network Updates should never be null.", network);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates(java.util.Set)}.
	 */
	@Test
	public void testGetNetworkUpdatesSetOfNetworkUpdateType() {
		Future<Network> network = client.getNetworkUpdates(EnumSet.of(NetworkUpdateType.SHARED_ITEM, NetworkUpdateType.CONNECTION_UPDATE));
		assertNotNull("Network Updates should never be null.", network);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates(java.util.Set, int, int)}.
	 */
	@Test
	public void testGetNetworkUpdatesIntIntSetOfNetworkUpdateType() {
		Future<Network> network = client.getNetworkUpdates(EnumSet.of(NetworkUpdateType.SHARED_ITEM, NetworkUpdateType.CONNECTION_UPDATE), 1, 5);
		assertNotNull("Network Updates should never be null.", network);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates(java.util.Set, java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testGetNetworkUpdatesDateDateSetOfNetworkUpdateType() {
		Future<Network> network = client.getNetworkUpdates(EnumSet.of(NetworkUpdateType.SHARED_ITEM, NetworkUpdateType.CONNECTION_UPDATE), getLastWeekDate(), getCurrentDate());
		assertNotNull("Network Updates should never be null.", network);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdates(java.util.Set, int, int, java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testGetNetworkUpdatesIntIntDateDateSetOfNetworkUpdateType() {
		Future<Network> network = client.getNetworkUpdates(EnumSet.of(NetworkUpdateType.SHARED_ITEM, NetworkUpdateType.CONNECTION_UPDATE), 5, 1, getLastWeekDate(), getCurrentDate());
		assertNotNull("Network Updates should never be null.", network);
	}
	
	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getNetworkUpdateComments(java.lang.String)}.
	 */
	@Test
	public void testGetNetworkUpdateCommentsString() {
		final String networkUpdateId = TestConstants.LINKED_IN_TEST_NETWORK_UPDATE_ID;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Network Update ID"), networkUpdateId);
		Future<UpdateComments> updateComments = client.getNetworkUpdateComments(networkUpdateId);
		assertNotNull("Network Update Comments should never be null.", updateComments);
	}
	
	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getProfileById(java.lang.String, com.google.code.linkedinapi.client.enumeration.ProfileType)}.
	 */
	@Test
	public void testGetProfileByIdString() {
		final String id = TestConstants.LINKED_IN_TEST_ID;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "ID"), id);
		Future<Person> profile = client.getProfileById(id);
		assertNotNull("Profile should never be null.", profile);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getProfileById(java.lang.String, com.google.code.linkedinapi.client.enumeration.ProfileType, java.util.Set)}.
	 */
	@Test
	public void testGetProfileByIdStringSetOfProfileField() {
		final String id = TestConstants.LINKED_IN_TEST_ID;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "ID"), id);
		Future<Person> profile = client.getProfileById(id, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
		assertNotNull("Profile should never be null.", profile);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getProfileByUrl(java.lang.String, com.google.code.linkedinapi.client.enumeration.ProfileType)}.
	 */
	@Test
	public void testGetProfileByUrlStringProfileType() {
		final String url = TestConstants.LINKED_IN_TEST_URL;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "URL"), url);
		Future<Person> profile = client.getProfileByUrl(url, ProfileType.STANDARD);
		assertNotNull("Profile should never be null.", profile);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getProfileByUrl(java.lang.String, com.google.code.linkedinapi.client.enumeration.ProfileType, java.util.Set)}.
	 */
	@Test
	public void testGetProfileByUrlStringProfileTypeSetOfProfileField() {
		final String url = TestConstants.LINKED_IN_TEST_URL;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "URL"), url);
		Future<Person> profile = client.getProfileByUrl(url, ProfileType.STANDARD, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
		assertNotNull("Profile should never be null.", profile);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getProfileForCurrentUser()}.
	 */
	@Test
	public void testGetProfileForCurrentUser() {
		Future<Person> profile = client.getProfileForCurrentUser();
		assertNotNull("Profile should never be null.", profile);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#getProfileForCurrentUser(java.util.Set)}.
	 */
	@Test
	public void testGetProfileForCurrentUserSetOfProfileField() {
		Future<Person> profile = client.getProfileForCurrentUser(EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
		assertNotNull("Profile should never be null.", profile);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#postComment(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPostComment() {
		final String networkUpdateId = TestConstants.LINKED_IN_TEST_NETWORK_UPDATE_ID;
		final String commentText = TestConstants.LINKED_IN_TEST_NETWORK_UPDATE_COMMENT;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Network Update ID"), networkUpdateId);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Comment Text"), commentText);
		client.postComment(networkUpdateId, commentText);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#postNetworkUpdate(java.lang.String)}.
	 */
	@Test
	public void testPostNetworkUpdate() {
		final String networkUpdateText = TestConstants.LINKED_IN_TEST_NETWORK_UPDATE_TEXT;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Network Update Text"), networkUpdateText);
		client.postNetworkUpdate(networkUpdateText);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople()}.
	 */
	@Test
	public void testSearchPeople() {
		Future<People> people = client.searchPeople();
		assertNotNull("People should never be null.", people);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(java.util.Map)}.
	 */
	@Test
	public void testSearchPeopleMapOfSearchParameterString() {
		final String searchParameters = TestConstants.LINKED_IN_TEST_SEARCH_PARAMS;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Search Parameters"), searchParameters);
		Future<People> people = client.searchPeople(getSearchParametersMap(searchParameters));
		assertNotNull("People should never be null.", people);
	}

//	/**
//	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(int, int)}.
//	 */
//	@Test
//	public void testSearchPeopleIntInt() {
//		Future<People> people = client.searchPeople(1, 5);
//		assertNotNull("People should never be null.", people);
//	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(java.util.Map, int, int)}.
	 */
	@Test
	public void testSearchPeopleMapOfSearchParameterStringIntInt() {
		final String searchParameters = TestConstants.LINKED_IN_TEST_SEARCH_PARAMS;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Search Parameters"), searchParameters);
		Future<People> people = client.searchPeople(getSearchParametersMap(searchParameters), 1, 5);
		assertNotNull("People should never be null.", people);
	}

//	/**
//	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(com.google.code.linkedinapi.client.enumeration.SearchSortOrder)}.
//	 */
//	@Test
//	public void testSearchPeopleSearchSortOrder() {
//		Future<People> people = client.searchPeople(SearchSortOrder.RELEVANCE);
//		assertNotNull("People should never be null.", people);
//	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(java.util.Map, com.google.code.linkedinapi.client.enumeration.SearchSortOrder)}.
	 */
	@Test
	public void testSearchPeopleMapOfSearchParameterStringSearchSortOrder() {
		final String searchParameters = TestConstants.LINKED_IN_TEST_SEARCH_PARAMS;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Search Parameters"), searchParameters);
		Future<People> people = client.searchPeople(getSearchParametersMap(searchParameters), SearchSortOrder.RELEVANCE);
		assertNotNull("People should never be null.", people);
	}

//	/**
//	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(int, int, com.google.code.linkedinapi.client.enumeration.SearchSortOrder)}.
//	 */
//	@Test
//	public void testSearchPeopleIntIntSearchSortOrder() {
//		Future<People> people = client.searchPeople(1, 5, SearchSortOrder.RELEVANCE);
//		assertNotNull("People should never be null.", people);
//	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#searchPeople(java.util.Map, int, int, com.google.code.linkedinapi.client.enumeration.SearchSortOrder)}.
	 */
	@Test
	public void testSearchPeopleMapOfSearchParameterStringIntIntSearchSortOrder() {
		final String searchParameters = TestConstants.LINKED_IN_TEST_SEARCH_PARAMS;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Search Parameters"), searchParameters);
		Future<People> people = client.searchPeople(getSearchParametersMap(searchParameters), 1, 5, SearchSortOrder.RELEVANCE);
		assertNotNull("People should never be null.", people);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#sendInviteByEmail(java.lang.String, String, String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendInviteByEmailStringStringString() {
		final String inviteText = TestConstants.LINKED_IN_TEST_INVITE_TEXT;
		final String inviteSubject = TestConstants.LINKED_IN_TEST_INVITE_SUBJECT;
		final String inviteRecepient = TestConstants.LINKED_IN_TEST_INVITE_EMAIL;
		final String firstName = TestConstants.LINKED_IN_TEST_INVITE_FIRST_NAME;
		final String lastName = TestConstants.LINKED_IN_TEST_INVITE_LAST_NAME;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "First Name"), firstName);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Last Name"), lastName);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Invite Text"), inviteText);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Invite Subject"), inviteSubject);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Invite Recepient"), inviteRecepient);
		client.sendInviteByEmail(inviteRecepient, firstName, lastName, inviteSubject, inviteText);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#sendInviteById(java.lang.String, String, String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendInviteByIdStringStringString() {
		final String inviteText = TestConstants.LINKED_IN_TEST_INVITE_TEXT;
		final String inviteSubject = TestConstants.LINKED_IN_TEST_INVITE_SUBJECT;
		final String inviteRecepient = TestConstants.LINKED_IN_TEST_INVITE_RECEPIENT_ID;
		final String authHeader = TestConstants.LINKED_IN_TEST_INVITE_AUTH_HEADER;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Invite Text"), inviteText);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Invite Subject"), inviteSubject);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Invite Recepient"), inviteRecepient);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Auth Header"), authHeader);
		client.sendInviteById(inviteRecepient, inviteSubject, inviteText, authHeader);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#sendMessage(java.util.List, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendMessage() {
		final String messageText = TestConstants.LINKED_IN_TEST_MESSAGE_TEXT;
		final String messageSubject = TestConstants.LINKED_IN_TEST_MESSAGE_SUBJECT;
		final String messageRecepients = TestConstants.LINKED_IN_TEST_MESSAGE_RECEPIENT_IDS;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Message Text"), messageText);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Message Subject"), messageSubject);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Message Recepient"), messageRecepients);
		client.sendMessage(getRecepientIdsList(messageRecepients), messageSubject, messageText);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#updateCurrentStatus(java.lang.String)}.
	 */
	@Test
	public void testUpdateCurrentStatus() {
		final String statusText = TestConstants.LINKED_IN_TEST_STATUS_TEXT;
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Status Text"), statusText);
		client.updateCurrentStatus(statusText);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient#deleteCurrentStatus()}.
	 */
	@Test
	public void testDeleteCurrentStatus() {
		client.deleteCurrentStatus();
	}
}
