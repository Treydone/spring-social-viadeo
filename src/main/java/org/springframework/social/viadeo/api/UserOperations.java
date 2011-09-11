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
}
