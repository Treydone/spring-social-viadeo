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
package org.springframework.social.viadeo.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.viadeo.api.Career;
import org.springframework.social.viadeo.api.ContactCards;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.InboxMessage;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.UserOperations;
import org.springframework.social.viadeo.api.ViadeoProfile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class UserTemplate extends AbstractViadeoOperations implements UserOperations {

	public UserTemplate(ViadeoTemplate viadeoTemplate, boolean isAuthorized) {
		super(viadeoTemplate, isAuthorized);
	}

	@Override
	public ViadeoProfile getUserProfile() {
		requireAuthorization();
		return getUserProfile(ME);
	}

	@Override
	public ViadeoProfile getUserProfile(String userId) {
		return get(userId, ViadeoProfile.class);
	}

	@Override
	public List<ViadeoProfile> getContacts() {
		return getContacts(ME);
	}

	@Override
	public List<ViadeoProfile> getContacts(int page) {
		return getContacts(ME, page);
	}

	@Override
	public List<ViadeoProfile> getContacts(String userId) {
		return getContacts(userId, 0);
	}

	@Override
	public List<ViadeoProfile> getContacts(String userId, int page) {
		requireAuthorization();
		URI uri = buildUri(userId + "/contacts").queryParam(USER_DETAIL, FULL).queryParam(LIMIT, "20").queryParam(PAGE, Integer.toString(page)).build();
		return get(uri, Contacts.class).getContacts();
	}

	@Override
	public List<News> getNewsFeed() {
		return getNewsFeed(ME);
	}

	@Override
	public List<News> getNewsFeed(String userId) {
		requireAuthorization();
		URI uri = buildUri(userId + "/home_newsfeed").queryParam(USER_DETAIL, FULL).queryParam(LIMIT, "50").build();
		return get(uri, Feed.class).getNews();
	}
	

	@Override
	public List<News> getUserFeed() {
		return getUserFeed(ME);
	}

	@Override
	public List<News> getUserFeed(String userId) {
		requireAuthorization();
		URI uri = buildUri(userId + "/newsfeed").queryParam(USER_DETAIL, FULL).queryParam(LIMIT, "50").build();
		return get(uri, Feed.class).getNews();
	}

	@Override
	public List<Experience> getExperiences() {
		return getExperiences(ME);
	}

	@Override
	public List<Experience> getExperiences(String userId) {
		requireAuthorization();
		URI uri = buildUri(userId + "/career").queryParam(USER_DETAIL, FULL).build();
		return get(uri, Career.class).getExperiences();
	}

	@Override
	public void updateStatus(String status) {
		requireAuthorization();
		if (status.length() > 140) {
			throw new IllegalArgumentException("The message is more than 140 caracters");
		}
		MultiValueMap<String, String> parts = new LinkedMultiValueMap<String, String>();
		parts.set("message", status);
		post(buildUri("status").build(), parts, String.class);
	}

	@Override
	public List<ViadeoProfile> search(String keyword) {
		requireAuthorization();
		URI uri = buildUri("search/users").queryParam(USER_DETAIL, FULL).queryParam("keyword", keyword)
				.queryParam(LIMIT, "50").build();
		return get(uri, Contacts.class).getContacts();
	}

	@Override
	public List<ContactCards> getContactCards(String userId) {
		requireAuthorization();
		URI uri = buildUri(userId + "/contact_cards").build();
		return get(uri, VisitCards.class).getContactCards();
	}

	@Override
	public List<ContactCards> getContactCards() {
		return getContactCards(ME);
	}

	@Override
	public List<InboxMessage> getInboxMessages() {
		requireAuthorization();
		URI uri = buildUri(ME + "/inbox").queryParam(USER_DETAIL, FULL).queryParam(LIMIT, "50").build();
		return get(uri, InboxMessagesResult.class).getInboxMessages();
	}
}
