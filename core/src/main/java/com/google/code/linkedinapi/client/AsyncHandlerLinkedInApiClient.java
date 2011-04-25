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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComments;

/**
 * The Interface AsyncLinkedInApiClient. This interface can be used for asynchronous invocation of API methods.
 * 
 * @author Nabeel Mukhtar
 */
public interface AsyncHandlerLinkedInApiClient extends LinkedInAuthenticationClient {

    // Profile API. Return Profile bean

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @return the profile for current user
     */
    public void getProfileForCurrentUser(AsyncResponseHandler<Person> handler);

    /**
     * Gets the profile by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param id the id
     * @param profileType the profile type
     * 
     * @return the profile by id
     */
    public void getProfileById(String id, AsyncResponseHandler<Person> handler);
    
    /**
     * Gets the profile by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param url the url
     * @param profileType the profile type
     * 
     * @return the profile by url
     */
    public void getProfileByUrl(String url, ProfileType profileType, AsyncResponseHandler<Person> handler);

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the profile for current user
     */
    public void getProfileForCurrentUser(Set<ProfileField> profileFields, AsyncResponseHandler<Person> handler);

    /**
     * Gets the profile by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param id the id
     * @param profileType the profile type
     * @param profileFields the profile fields
     * 
     * @return the profile by id
     */
    public void getProfileById(String id, Set<ProfileField> profileFields, AsyncResponseHandler<Person> handler);
    
    /**
     * Gets the profile by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param url the url
     * @param profileType the profile type
     * @param profileFields the profile fields
     * 
     * @return the profile by url
     */
    public void getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields, AsyncResponseHandler<Person> handler);
    
    /**
     * Gets the profile by API request.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param apiRequest the api request
     * 
     * @return the profile by api request
     */
    public void getProfileByApiRequest(ApiStandardProfileRequest apiRequest, AsyncResponseHandler<Person> handler);

    // Network Updates API. Return Network Update bean

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @return the network updates
     */
    public void getNetworkUpdates(AsyncResponseHandler<Network> handler);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public void getNetworkUpdates(int start, int count, AsyncResponseHandler<Network> handler);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public void getNetworkUpdates(Date startDate, Date endDate, AsyncResponseHandler<Network> handler);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * 
     * @return the network updates
     */
    public void getNetworkUpdates(Set<NetworkUpdateType> updateTypes, AsyncResponseHandler<Network> handler);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public void getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, AsyncResponseHandler<Network> handler);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public void getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate, AsyncResponseHandler<Network> handler);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * @param startDate the start date
     * @param endDate the end date
     * @return the network updates
     */
    public void getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate, AsyncResponseHandler<Network> handler);

    /**
     * Gets the network update comments.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     * 
     * @return the network update comments
     */
    public void getNetworkUpdateComments(String networkUpdateId, AsyncResponseHandler<UpdateComments> handler);

    // Connections API

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @return the connections for current user
     */
    public void getConnectionsForCurrentUser(AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * 
     * @return the connections by id
     */
    public void getConnectionsById(String id, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by email.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param email the email
     * 
     * @return the connections by email
     */
//    public AsyncResponseHandler<Connections> getConnectionsByEmail(String email);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * 
     * @return the connections by url
     */
    public void getConnectionsByUrl(String url, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the connections for current user
     */
    public void getConnectionsForCurrentUser(Set<ProfileField> profileFields, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * 
     * @return the connections by id
     */
    public void getConnectionsById(String id, Set<ProfileField> profileFields, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by email.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param email the email
     * @param profileFields the profile fields
     * 
     * @return the connections by email
     */
//    public AsyncResponseHandler<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * 
     * @return the connections by url
     */
    public void getConnectionsByUrl(String url, Set<ProfileField> profileFields, AsyncResponseHandler<Connections> handler);

    // Connections API with Paging

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public void getConnectionsForCurrentUser(int start, int count, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public void getConnectionsById(String id, int start, int count, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by email.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param email the email
     * @param start the start
     * @param count the count
     * 
     * @return the connections by email
     */
//    public AsyncResponseHandler<Connections> getConnectionsByEmail(String email, int start, int count);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public void getConnectionsByUrl(String url, int start, int count, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public void getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public void getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count, AsyncResponseHandler<Connections> handler);

    /**
     * Gets the connections by email.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param email the email
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by email
     */
//    public AsyncResponseHandler<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public void getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count, AsyncResponseHandler<Connections> handler);

    // Search API

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @return the future< people>
     */
    public void searchPeople(AsyncResponseHandler<People> handler);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the future< people>
     */
    public void searchPeople(Map<SearchParameter, String> searchParameters, AsyncResponseHandler<People> handler);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the future< people>
     */
    public void searchPeople(Map<SearchParameter, String> searchParameters, int start, int count, AsyncResponseHandler<People> handler);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the future< people>
     */
    public void searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder, AsyncResponseHandler<People> handler);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the future< people>
     */
    public void searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder, AsyncResponseHandler<People> handler);

    // Post Network Update API

    /**
     * Post network update.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1009">http://developer.linkedin.com/docs/DOC-1009</a>
     * 
     * @param updateText the update text
     * 
     * @return the future<?>
     */
    public void postNetworkUpdate(String updateText, AsyncResponseHandler<?> handler);

    // Post Comment API

    /**
     * Post comment.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     * @param commentText the comment text
     * 
     * @return the future<?>
     */
    public void postComment(String networkUpdateId, String commentText, AsyncResponseHandler<?> handler);

    // Status Update API

    /**
     * Update current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     * 
     * @param status the status
     * 
     * @return the future<?>
     */
    public void updateCurrentStatus(String status, AsyncResponseHandler<?> handler);

    /**
     * Delete current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     * 
     * @return the future<?>
     */
    public void deleteCurrentStatus(AsyncResponseHandler<?> handler);

    // Messaging API

    /**
     * Send message.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1044">http://developer.linkedin.com/docs/DOC-1044</a>
     * 
     * @param recepientIds the recepient ids
     * @param subject the subject
     * @param message the message
     * 
     * @return the future<?>
     */
    public void sendMessage(List<String> recepientIds, String subject, String message, AsyncResponseHandler<?> handler);

    // Invitation API

    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     * 
     * @param email the recepient email
     * @param firstName the first name
     * @param lastName the last name
     * @param subject the subject
     * @param message the message
     * @return the future<?>
     */
    public void sendInviteByEmail(String email, String firstName, String lastName, String subject, String message, AsyncResponseHandler<?> handler);

    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     * <p>
     * To call this method one needs an auth header parameter. This can be obtained by getting {@link ApiStandardProfileRequest#getHeaders()} from {@link Person#getApiStandardProfileRequest()}
     * and then getting the value of header with name {@link ApplicationConstants#AUTH_HEADER_NAME}. 
     * </p> 
     * 
     * @param recepientId the recepient id
     * @param subject the subject
     * @param message the message
     * @param authHeader the auth header
     * 
     * @return the future<?>
     */
    public void sendInviteById(String recepientId, String subject, String message, String authHeader, AsyncResponseHandler<?> handler);

    /**
     * Send invite.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1012">http://developer.linkedin.com/docs/DOC-1012</a>
     * <p>
     * To call this method one needs an auth header parameter. This can be obtained by getting {@link ApiStandardProfileRequest#getHeaders()} from {@link Person#getApiStandardProfileRequest()}
     * and then getting the value of header with name {@link ApplicationConstants#AUTH_HEADER_NAME}. 
     * </p> 
     * 
     * @param recepient the recepient
     * @param subject the subject
     * @param message the message
     * 
     * @return the future<?>
     */
    public void sendInviteToPerson(Person recepient, String subject, String message, AsyncResponseHandler<?> handler);
}
