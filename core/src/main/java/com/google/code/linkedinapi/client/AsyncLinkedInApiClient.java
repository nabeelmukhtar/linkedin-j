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
import java.util.concurrent.Future;

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
public interface AsyncLinkedInApiClient extends LinkedInAuthenticationClient {

    // Profile API. Return Profile bean

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @return the profile for current user
     */
    public Future<Person> getProfileForCurrentUser();

    /**
     * Gets the profile by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param id the id
     * @param profileType the profile type
     * 
     * @return the profile by id
     */
    public Future<Person> getProfileById(String id);
    
    /**
     * Gets the profile by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param url the url
     * @param profileType the profile type
     * 
     * @return the profile by url
     */
    public Future<Person> getProfileByUrl(String url, ProfileType profileType);

    /**
     * Gets the profile for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the profile for current user
     */
    public Future<Person> getProfileForCurrentUser(Set<ProfileField> profileFields);

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
    public Future<Person> getProfileById(String id, Set<ProfileField> profileFields);
    
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
    public Future<Person> getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields);
    
    /**
     * Gets the profile by API request.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1002">http://developer.linkedin.com/docs/DOC-1002</a>
     * 
     * @param apiRequest the api request
     * 
     * @return the profile by api request
     */
    public Future<Person> getProfileByApiRequest(ApiStandardProfileRequest apiRequest);

    // Network Updates API. Return Network Update bean

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @return the network updates
     */
    public Future<Network> getNetworkUpdates();

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Future<Network> getNetworkUpdates(int start, int count);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Future<Network> getNetworkUpdates(Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1006">http://developer.linkedin.com/docs/DOC-1006</a>
     * 
     * @param updateTypes the update types
     * 
     * @return the network updates
     */
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes);

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
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count);

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
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate);

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
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate);

    /**
     * Gets the network update comments.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1043">http://developer.linkedin.com/docs/DOC-1043</a>
     * 
     * @param networkUpdateId the network update id
     * 
     * @return the network update comments
     */
    public Future<UpdateComments> getNetworkUpdateComments(String networkUpdateId);

    // Connections API

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @return the connections for current user
     */
    public Future<Connections> getConnectionsForCurrentUser();

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * 
     * @return the connections by id
     */
    public Future<Connections> getConnectionsById(String id);

    /**
     * Gets the connections by email.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param email the email
     * 
     * @return the connections by email
     */
//    public Future<Connections> getConnectionsByEmail(String email);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * 
     * @return the connections by url
     */
    public Future<Connections> getConnectionsByUrl(String url);

    /**
     * Gets the connections for current user.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param profileFields the profile fields
     * 
     * @return the connections for current user
     */
    public Future<Connections> getConnectionsForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Gets the connections by id.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param id the id
     * @param profileFields the profile fields
     * 
     * @return the connections by id
     */
    public Future<Connections> getConnectionsById(String id, Set<ProfileField> profileFields);

    /**
     * Gets the connections by email.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param email the email
     * @param profileFields the profile fields
     * 
     * @return the connections by email
     */
//    public Future<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields);

    /**
     * Gets the connections by url.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1004">http://developer.linkedin.com/docs/DOC-1004</a>
     * 
     * @param url the url
     * @param profileFields the profile fields
     * 
     * @return the connections by url
     */
    public Future<Connections> getConnectionsByUrl(String url, Set<ProfileField> profileFields);

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
    public Future<Connections> getConnectionsForCurrentUser(int start, int count);

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
    public Future<Connections> getConnectionsById(String id, int start, int count);

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
//    public Future<Connections> getConnectionsByEmail(String email, int start, int count);

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
    public Future<Connections> getConnectionsByUrl(String url, int start, int count);

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
    public Future<Connections> getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count);

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
    public Future<Connections> getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count);

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
//    public Future<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count);

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
    public Future<Connections> getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count);

    // Search API

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @return the future< people>
     */
    public Future<People> searchPeople();

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * 
     * @return the future< people>
     */
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters);

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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Search people.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1005">http://developer.linkedin.com/docs/DOC-1005</a>
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the future< people>
     */
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    // Post Network Update API

    /**
     * Post network update.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1009">http://developer.linkedin.com/docs/DOC-1009</a>
     * 
     * @param updateText the update text
     * 
     * @return the future<?>
     */
    public Future<?> postNetworkUpdate(String updateText);

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
    public Future<?> postComment(String networkUpdateId, String commentText);

    // Status Update API

    /**
     * Update current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     * 
     * @param status the status
     * 
     * @return the future<?>
     */
    public Future<?> updateCurrentStatus(String status);

    /**
     * Delete current status.
     * For details see <a href="http://developer.linkedin.com/docs/DOC-1007">http://developer.linkedin.com/docs/DOC-1007</a>
     * 
     * @return the future<?>
     */
    public Future<?> deleteCurrentStatus();

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
    public Future<?> sendMessage(List<String> recepientIds, String subject, String message);

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
    public Future<?> sendInviteByEmail(String email, String firstName, String lastName, String subject, String message);

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
    public Future<?> sendInviteById(String recepientId, String subject, String message, String authHeader);

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
    public Future<?> sendInviteToPerson(Person recepient, String subject, String message);
}
