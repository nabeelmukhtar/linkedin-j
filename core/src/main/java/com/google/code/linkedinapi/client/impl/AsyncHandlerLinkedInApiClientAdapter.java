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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.google.code.linkedinapi.client.AsyncHandlerLinkedInApiClient;
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
import com.google.code.linkedinapi.schema.UpdateComments;

/**
 * @author Nabeel Mukhtar
 *
 */
public class AsyncHandlerLinkedInApiClientAdapter implements AsyncHandlerLinkedInApiClient {

    /** Field description */
    private LinkedInApiClient client;

    /** Field description */
    private ExecutorService taskExecutor;

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncHandlerLinkedInApiClientAdapter(LinkedInApiClient client, ExecutorService taskExecutor) {
        this.client  = client;
        this.taskExecutor = taskExecutor;
    }

    /**
     * Method description
     *
     *
     * @param task
     *
     * @return
     */
    @SuppressWarnings("unchecked")
	protected Future execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Method description
     *
     *
     * @param task
     * @param <T>
     *
     * @return
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsById(final String id, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id);
            }
        }));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsById(final String id, final Set<ProfileField> profileFields, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id, profileFields);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsByUrl(final String url, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsByUrl(final String url, final Set<ProfileField> profileFields, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url, profileFields);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsForCurrentUser(final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser();
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsForCurrentUser(final Set<ProfileField> profileFields, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser(profileFields);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsById(final String id, final int start, final int count, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsById(final String id, final Set<ProfileField> profileFields, final int start, final int count, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id, profileFields, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsByUrl(final String url, final int start, final int count, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsByUrl(final String url, final Set<ProfileField> profileFields, final int start, final int count, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url, profileFields, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsForCurrentUser(final int start, final int count, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser(start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getConnectionsForCurrentUser(final Set<ProfileField> profileFields, final int start, final int count, final AsyncResponseHandler<Connections> handler) {
        handler.setFuture(execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser(profileFields, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates();
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final int start, final int count, final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final Date startDate, final Date endDate, final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(startDate, endDate);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final int start, final int count, final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final Date startDate, final Date endDate, final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes, startDate, endDate);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final int start, final int count, final Date startDate,
            final Date endDate, final AsyncResponseHandler<Network> handler) {
        handler.setFuture(execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes, start, count, startDate, endDate);
            }
        }));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void getNetworkUpdateComments(final String networkUpdateId, final AsyncResponseHandler<UpdateComments> handler) {
        handler.setFuture(execute(new Callable<UpdateComments>() {
            @Override
            public UpdateComments call() throws Exception {
                return client.getNetworkUpdateComments(networkUpdateId);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileById(final String id, final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileById(id);
            }
        }));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileById(final String id, final Set<ProfileField> profileFields, final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileById(id, profileFields);
            }
        }));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileByUrl(final String url, final ProfileType profileType, final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileByUrl(url, profileType);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileByUrl(final String url, final ProfileType profileType, final Set<ProfileField> profileFields, final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileByUrl(url, profileType, profileFields);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileByApiRequest(final ApiStandardProfileRequest apiRequest, final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileByApiRequest(apiRequest);
            }
        }));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileForCurrentUser(final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileForCurrentUser();
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getProfileForCurrentUser(final Set<ProfileField> profileFields, final AsyncResponseHandler<Person> handler) {
        handler.setFuture(execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileForCurrentUser(profileFields);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void postComment(final String networkUpdateId, final String commentText, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.postComment(networkUpdateId, commentText);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void postNetworkUpdate(final String updateText, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.postNetworkUpdate(updateText);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void searchPeople(final AsyncResponseHandler<People> handler) {
        handler.setFuture(execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople();
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void searchPeople(final Map<SearchParameter, String> searchParameters, final AsyncResponseHandler<People> handler) {
        handler.setFuture(execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void searchPeople(final Map<SearchParameter, String> searchParameters, final int start, final int count, final AsyncResponseHandler<People> handler) {
        handler.setFuture(execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters, start, count);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void searchPeople(final Map<SearchParameter, String> searchParameters, final SearchSortOrder sortOrder, final AsyncResponseHandler<People> handler) {
        handler.setFuture(execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters, sortOrder);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void searchPeople(final Map<SearchParameter, String> searchParameters, final int start, final int count,
                                       final SearchSortOrder sortOrder, final AsyncResponseHandler<People> handler) {
        handler.setFuture(execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters, start, count, sortOrder);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void sendInviteByEmail(final String email, final String firstName, final String lastName, final String subject, final String message, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.sendInviteByEmail(email, firstName, lastName, subject, message);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void sendInviteToPerson(final Person recepient, final String subject, final String message, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.sendInviteToPerson(recepient, subject, message);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void sendInviteById(final String recepientId, final String subject, final String message, final String authHeader, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.sendInviteById(recepientId, subject, message, authHeader);
            }
        }));
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void sendMessage(final List<String> recepientIds, final String subject, final String message, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.sendMessage(recepientIds, subject, message);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void updateCurrentStatus(final String status, final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.updateCurrentStatus(status);
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
	@Override
    public void deleteCurrentStatus(final AsyncResponseHandler<?> handler) {
        handler.setFuture(execute(new Runnable() {
            @Override
            public void run() {
                client.deleteCurrentStatus();
            }
        }));
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

	@Override
	public void addLocale(Locale locale) {
		client.addLocale(locale);
	}
}
