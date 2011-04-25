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
package com.google.code.linkedinapi.client.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.google.code.linkedinapi.client.AsyncLinkedInApiClient;
import com.google.code.linkedinapi.client.AsyncResponseHandler;
import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.SchemaEntity;
import com.google.code.linkedinapi.schema.UpdateComments;

/**
 * @author Nabeel Mukhtar
 *
 */
public class AsyncLinkedInApiClientAdapter implements AsyncLinkedInApiClient {

    /** Field description */
    private AsyncHandlerLinkedInApiClientAdapter client;
    
    /** Field description */

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncLinkedInApiClientAdapter(LinkedInApiClient client, ExecutorService taskExecutor) {
        this.client  = new AsyncHandlerLinkedInApiClientAdapter(client, taskExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsById(final String id) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsById(id, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsById(final String id, final Set<ProfileField> profileFields) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsById(id, profileFields, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsByUrl(final String url) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsByUrl(url, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsByUrl(final String url, final Set<ProfileField> profileFields) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsByUrl(url, profileFields, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser() {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsForCurrentUser(handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser(final Set<ProfileField> profileFields) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsForCurrentUser(profileFields, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsById(final String id, final int start, final int count) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsById(id, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsById(final String id, final Set<ProfileField> profileFields, final int start, final int count) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsById(id, profileFields, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsByUrl(final String url, final int start, final int count) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsById(url, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsByUrl(final String url, final Set<ProfileField> profileFields, final int start, final int count) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsById(url, profileFields, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser(final int start, final int count) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsForCurrentUser(start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser(final Set<ProfileField> profileFields, final int start, final int count) {
    	final NullResponseHandler<Connections> handler = new NullResponseHandler<Connections>();
    	client.getConnectionsForCurrentUser(profileFields, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates() {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final int start, final int count) {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Date startDate, final Date endDate) {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(startDate, endDate, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes) {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(updateTypes, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final int start, final int count) {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(updateTypes, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final Date startDate, final Date endDate) {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(updateTypes, startDate, endDate, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final int start, final int count, final Date startDate,
            final Date endDate) {
    	final NullResponseHandler<Network> handler = new NullResponseHandler<Network>();
    	client.getNetworkUpdates(updateTypes, start, count, startDate, endDate, handler);
    	
    	return handler.getFuture();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Future<UpdateComments> getNetworkUpdateComments(final String networkUpdateId) {
    	final NullResponseHandler<UpdateComments> handler = new NullResponseHandler<UpdateComments>();
    	client.getNetworkUpdateComments(networkUpdateId, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileById(final String id) {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileById(id, handler);
    	
    	return handler.getFuture();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileById(final String id, final Set<ProfileField> profileFields) {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileById(id, profileFields, handler);
    	
    	return handler.getFuture();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileByUrl(final String url, final ProfileType profileType) {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileByUrl(url, profileType, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileByUrl(final String url, final ProfileType profileType, final Set<ProfileField> profileFields) {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileByUrl(url, profileType, profileFields, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileByApiRequest(final ApiStandardProfileRequest apiRequest) {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileByApiRequest(apiRequest, handler);
    	
    	return handler.getFuture();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileForCurrentUser() {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileForCurrentUser(handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileForCurrentUser(final Set<ProfileField> profileFields) {
    	final NullResponseHandler<Person> handler = new NullResponseHandler<Person>();
    	client.getProfileForCurrentUser(profileFields, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> postComment(final String networkUpdateId, final String commentText) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.postComment(networkUpdateId, commentText, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> postNetworkUpdate(final String updateText) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.postNetworkUpdate(updateText, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<People> searchPeople() {
    	final NullResponseHandler<People> handler = new NullResponseHandler<People>();
    	client.searchPeople(handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters) {
    	final NullResponseHandler<People> handler = new NullResponseHandler<People>();
    	client.searchPeople(searchParameters, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters, final int start, final int count) {
    	final NullResponseHandler<People> handler = new NullResponseHandler<People>();
    	client.searchPeople(searchParameters, start, count, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters, final SearchSortOrder sortOrder) {
    	final NullResponseHandler<People> handler = new NullResponseHandler<People>();
    	client.searchPeople(searchParameters, sortOrder, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters, final int start, final int count,
                                       final SearchSortOrder sortOrder) {
    	final NullResponseHandler<People> handler = new NullResponseHandler<People>();
    	client.searchPeople(searchParameters, start, count, sortOrder, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> sendInviteByEmail(final String email, final String firstName, final String lastName, final String subject, final String message) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.sendInviteByEmail(email, firstName, lastName, subject, message, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> sendInviteToPerson(final Person recepient, final String subject, final String message) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.sendInviteToPerson(recepient, subject, message, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> sendInviteById(final String recepientId, final String subject, final String message, final String authHeader) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.sendInviteById(recepientId, subject, message, authHeader, handler);
    	
    	return handler.getFuture();
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> sendMessage(final List<String> recepientIds, final String subject, final String message) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.sendMessage(recepientIds, subject, message, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> updateCurrentStatus(final String status) {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.updateCurrentStatus(status, handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public Future<?> deleteCurrentStatus() {
    	final NullResponseHandler handler = new NullResponseHandler();
    	client.deleteCurrentStatus(handler);
    	
    	return handler.getFuture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInAccessToken getAccessToken() {
        return client.getAccessToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInApiConsumer getApiConsumer() {
        return client.getApiConsumer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccessToken(LinkedInAccessToken accessToken) {
    	client.setAccessToken(accessToken);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setApiConsumer(LinkedInApiConsumer apiConsumer) {
    	client.setApiConsumer(apiConsumer);
    }
    
    /**
     * Sets the request headers.
     *
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	client.setRequestHeaders(requestHeaders);
    }

    /**
     * Gets the request headers.
     *
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders() {
        return client.getRequestHeaders();
    }

    /**
     * Adds the request header.
     *
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue) {
        client.addRequestHeader(headerName, headerValue);
    }

    /**
     * Removes the request header.
     *
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName) {
        client.removeRequestHeader(headerName);
    }
    
    private static class NullResponseHandler<T extends SchemaEntity> extends AsyncResponseHandler<T> {
		@Override
		public void handleResponse(T response) {
			// No-Op
		} 
    }

	@Override
	public void addLocale(Locale locale) {
		client.addLocale(locale);
	}
}
