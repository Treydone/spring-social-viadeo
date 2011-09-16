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

public interface UserOperations {

	/**
	 * Retrieves the profile for the authenticated user.
	 * 
	 * @return the user's profile information.
	 */
	ViadeoProfile getUserProfile();

	/**
	 * Retrieves the profile for the specified user.
	 * 
	 * @param userId
	 *            the Viadeo user ID to retrieve profile data for.
	 * @return the user's profile information.
	 */
	ViadeoProfile getUserProfile(String userId);

	/**
	 * Retrieves a list of custom contacs lists belonging to the specified user.
	 * 
	 * @return a list of contacts
	 */
	List<ViadeoProfile> getContacts();

	/**
	 * Retrieves a list of custom friend lists belonging to the authenticated
	 * user.
	 * 
	 * @param userId
	 *            the user's ID
	 * @return a list of contacts
	 */
	List<ViadeoProfile> getContacts(String userId);

	/**
	 * Retrieves recent feed entries for the authenticated user.
	 * 
	 * @return
	 */
	List<News> getNewsFeed();

	/**
	 * Retrieves recent feed entries for a given user.
	 * 
	 * @param userId
	 * @return
	 */
	List<News> getNewsFeed(String userId);

	/**
	 * Retrieves experiences for a given user.
	 * 
	 * @return
	 */
	List<Experience> getExperiences();

	/**
	 * Retrieves experiences for the authenticated user.
	 * 
	 * @param userId
	 * @return
	 */
	List<Experience> getExperiences(String userId);

	/**
	 * Edit the status of the current user.
	 * 
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
	 * @return the contact cards.
	 */
	List<ContactCards> getContactCards();

	/**
	 * Retrieve the visit cards of a given user.
	 * 
	 * @return the contact cards.
	 */
	List<ContactCards> getContactCards(String userId);

	/**
	 * Retrieve inbox messages of an authenticated member.
	 * 
	 * @return the inbox messages.
	 */
	List<InboxMessage> getInboxMessages();
}
