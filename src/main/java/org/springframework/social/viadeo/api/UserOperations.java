/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.viadeo.api;

import java.util.List;

import org.springframework.social.MissingAuthorizationException;

public interface UserOperations {

	/**
	 * Retrieve the profile for the authenticated user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return the user's profile information.
	 */
	ViadeoProfile getUserProfile();

	/**
	 * Retrieve the profile for the specified user.
	 * 
	 * @param userId the Viadeo user ID to retrieve profile data for.
	 * @return the user's profile information.
	 */
	ViadeoProfile getUserProfile(String userId);

	/**
	 * Retrieve a list of custom contacs lists belonging to the specified user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return a list of contacts
	 */
	List<ViadeoProfile> getContacts();

	/**
	 * Retrieve a list of custom friend lists belonging to the authenticated user.
	 * 
	 * @param userId the user's ID
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return a list of contacts
	 */
	List<ViadeoProfile> getContacts(String userId);

	/**
	 * Retrieve a member's newsfeed i.e. a list of updates from a member's professional contacts for the authenticated user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return
	 */
	List<News> getNewsFeed();

	/**
	 * Retrieve a member's newsfeed i.e. a list of updates from a member's professional contacts for a given user.
	 * 
	 * @param userId
	 * @return
	 */
	List<News> getNewsFeed(String userId);

	/**
	 * Retrieve a list of a member's newsfeed updates for the authenticated user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return
	 */
	List<News> getUserFeed();

	/**
	 * Retrieve a list of a member's newsfeed updates for a given user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @param userId
	 * @return
	 */
	List<News> getUserFeed(String userId);

	/**
	 * Retrieve experiences for a given user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return
	 */
	List<Experience> getExperiences();

	/**
	 * Retrieve experiences for the authenticated user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @param userId
	 * @return
	 */
	List<Experience> getExperiences(String userId);

	/**
	 * Edit the status of the current user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @param status
	 */
	void updateStatus(String status);

	/**
	 * Search a user on viadeo.
	 * 
	 * @param keyword
	 */
	List<ViadeoProfile> search(String keyword);

	/**
	 * Retrieve the visit cards of the current user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return the contact cards.
	 */
	List<ContactCards> getContactCards();

	/**
	 * Retrieve the visit cards of a given user.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return the contact cards.
	 */
	List<ContactCards> getContactCards(String userId);

	/**
	 * Retrieve inbox messages of an authenticated member.
	 * 
	 * @throws MissingAuthorizationException if ViadeoTemplate was not created with an access token.
	 * @return the inbox messages.
	 */
	List<InboxMessage> getInboxMessages();
}
