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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.viadeo.api.ContactCards;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.InboxMessage;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.Phone;
import org.springframework.social.viadeo.api.ViadeoProfile;

public class UserTemplateTest extends AbstractViadeoApiTest {

	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssZ");

	@Test
	public void getCurrentUser() throws ParseException {
		mockServer
				.expect(requestTo("https://api.viadeo.com/me?access_token=ACCESS_TOKEN"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testdata/full-profile-me"),
								responseHeaders));

		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Vincent", profile.getFirstName());
		assertEquals("DEVILLERS", profile.getLastName());
		assertEquals("vincent.devillers1", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/0021g557w9j1iw4m",
				profile.getProfileUrl());
		assertEquals(Long.valueOf(146), profile.getContactCount());
		assertEquals(
				"Karate (2eme Dan), piano, natation, apnee libre, robotique",
				profile.getInterests());
		assertEquals("Ingenieur d'etudes et de developpement, Viadeo",
				profile.getHeadline());
		assertEquals("", profile.getIntroduction());
		assertEquals("fr", profile.getLanguage());
		assertEquals(sdf.parse("2011-05-02T14:23:43+0200"),
				profile.getUpdatedTime());

		assertEquals("Garches", profile.getLocation().getCity());
		assertEquals("92", profile.getLocation().getZipcode());
		assertEquals("France", profile.getLocation().getCountry());
		assertEquals("Ile-de-France", profile.getLocation().getArea());
		assertEquals("(GMT+01:00) Bruxelles, Copenhague, Madrid, Paris",
				profile.getLocation().getTimezone());
		assertEquals("", profile.getLocation().getLatitude());
		assertEquals("", profile.getLocation().getLongitude());

		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentUser_unauthorized() {
		unauthorizedViadeo.userOperations().getUserProfile();
	}

	@Test
	public void getUserProfileById() throws ParseException {
		mockServer
				.expect(requestTo("https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg?access_token=ACCESS_TOKEN"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-profile-by-id"),
								responseHeaders));

		ViadeoProfile profile = viadeo.userOperations().getUserProfile(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Vincent", profile.getFirstName());
		assertEquals("DEVILLERS", profile.getLastName());
		assertEquals("vincent.devillers1", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/0021g557w9j1iw4m",
				profile.getProfileUrl());
		assertEquals(Long.valueOf(146), profile.getContactCount());
		assertEquals(
				"Karate (2eme Dan), piano, natation, apnee libre, robotique",
				profile.getInterests());
		assertEquals("Ingenieur d'etudes et de developpement, Viadeo",
				profile.getHeadline());
		assertEquals("", profile.getIntroduction());
		assertEquals("fr", profile.getLanguage());
		assertEquals(sdf.parse("2011-05-02T14:23:43+0200"),
				profile.getUpdatedTime());

		assertEquals("Garches", profile.getLocation().getCity());
		assertEquals("92", profile.getLocation().getZipcode());
		assertEquals("France", profile.getLocation().getCountry());
		assertEquals("Ile-de-France", profile.getLocation().getArea());
		assertEquals("(GMT+01:00) Bruxelles, Copenhague, Madrid, Paris",
				profile.getLocation().getTimezone());
		assertEquals("", profile.getLocation().getLatitude());
		assertEquals("", profile.getLocation().getLongitude());

		mockServer.verify();
	}

	@Test
	public void getCurrentContacts() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/me/contacts?access_token=ACCESS_TOKEN&user_detail=full&limit=20")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-contacts-for-me"),
								responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().getContacts();
		assertNotNull(contacts);
		assertEquals(20, contacts.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentContacts_unauthorized() {
		unauthorizedViadeo.userOperations().getContacts();
	}

	@Test
	public void getContactsForId() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/contacts?access_token=ACCESS_TOKEN&user_detail=full&limit=20")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-contacts-for-id"),
								responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().getContacts(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(contacts);
		assertEquals(20, contacts.size());
		mockServer.verify();
	}

	@Test
	public void getCurrentNewsFeed() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/me/home_newsfeed?access_token=ACCESS_TOKEN&user_detail=full&limit=50")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-home_newsfeed-for-me"),
								responseHeaders));

		List<News> news = viadeo.userOperations().getNewsFeed();
		assertNotNull(news);
		assertEquals(10, news.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentNewsFeed_unauthorized() {
		unauthorizedViadeo.userOperations().getNewsFeed();
	}

	@Test
	public void getNewsFeedForId() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/home_newsfeed?access_token=ACCESS_TOKEN&user_detail=full&limit=50")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-home_newsfeed-for-id"),
								responseHeaders));

		List<News> news = viadeo.userOperations().getNewsFeed(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(news);
		assertEquals(10, news.size());
		mockServer.verify();
	}
	
	@Test
	public void getCurrentUserFeed() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/me/newsfeed?access_token=ACCESS_TOKEN&user_detail=full&limit=50")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-newsfeed-for-me"),
								responseHeaders));

		List<News> news = viadeo.userOperations().getUserFeed();
		assertNotNull(news);
		assertEquals(50, news.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentUserFeed_unauthorized() {
		unauthorizedViadeo.userOperations().getUserFeed();
	}

	@Test
	public void getUserFeedForId() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/newsfeed?access_token=ACCESS_TOKEN&user_detail=full&limit=50")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/full-newsfeed-for-id"),
								responseHeaders));

		List<News> news = viadeo.userOperations().getUserFeed(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(news);
		assertEquals(50, news.size());
		mockServer.verify();
	}

	@Test
	public void getCurrentExperiences() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/me/career?access_token=ACCESS_TOKEN&user_detail=full")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testdata/career-for-me"),
								responseHeaders));

		List<Experience> experiences = viadeo.userOperations().getExperiences();
		assertNotNull(experiences);
		assertEquals(6, experiences.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentExperiences_unauthorized() {
		unauthorizedViadeo.userOperations().getExperiences();
	}

	@Test
	public void getExperiencesForId() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/career?access_token=ACCESS_TOKEN&user_detail=full")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testdata/career-for-id"),
								responseHeaders));

		List<Experience> experiences = viadeo.userOperations().getExperiences(
				"EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(experiences);
		assertEquals(6, experiences.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void updateStatus_unauthorized() {
		unauthorizedViadeo.userOperations().updateStatus("Mon nouveau status");
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateStatus_statusTooLong() {
		viadeo.userOperations()
				.updateStatus(
						"Veeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
								+ " looooooooooooooooooooooooooooonnnnnnnnnnnnngggggg "
								+ "staaaaaaaaatuuuuuuuuuuuuuuuuuusssssssssssss");
	}

	@Test
	public void updateStatus() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/status?access_token=ACCESS_TOKEN")
						.build())).andExpect(method(POST))
				.andExpect(body("message=Mon+nouveau+status"))
				.andRespond(withResponse("STATUS SENT", responseHeaders));

		viadeo.userOperations().updateStatus("Mon nouveau status");
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void search_unauthorized() {
		unauthorizedViadeo.userOperations().search("Vincent DEVILLERS");
	}

	@Test
	public void search() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/search/users?access_token=ACCESS_TOKEN&user_detail=full&keyword=Vincent+DEVILLERS&limit=50")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testdata/search-contacts"),
								responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().search(
				"Vincent DEVILLERS");
		assertNotNull(contacts);
		assertEquals(50, contacts.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentContactCard_unauthorized() {
		unauthorizedViadeo.userOperations().getContactCards();
	}

	@Test
	public void getCurrentContactCards() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/me/contact_cards?access_token=ACCESS_TOKEN")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/contact-cards-for-me"),
								responseHeaders));

		List<ContactCards> contactCards = viadeo.userOperations()
				.getContactCards();
		assertNotNull(contactCards);
		assertEquals(2, contactCards.size());

		ContactCards cardBusiness = contactCards.get(0);
		assertEquals("ticctDfItsvkatamzkruyuxstnwOOIowEcyVghfhbluVfsElvmdk",
				cardBusiness.getId());
		assertEquals("BUSINESS", cardBusiness.getKind());
		assertEquals("Garches", cardBusiness.getCity());
		assertEquals("92", cardBusiness.getPostcode());
		assertEquals("France", cardBusiness.getCountry());
		assertTrue(cardBusiness.getEmails().contains(
				"vincentdevillers@hotmail.fr"));
		assertTrue(cardBusiness.getPhones().contains(
				new Phone("MOBILE", "France", "+33", "0615053430")));

		ContactCards cardPerso = contactCards.get(1);
		assertEquals("IqsmeqAbllyupOxwpkdkkdVtAndoxjcrntDhwvvmrInbmOVmIryk",
				cardPerso.getId());
		assertEquals("PERSO", cardPerso.getKind());
		assertEquals("Garches", cardPerso.getCity());
		assertEquals("92", cardPerso.getPostcode());
		assertEquals("France", cardPerso.getCountry());
		assertEquals("Ile-de-France", cardPerso.getRegion());
		assertTrue(cardPerso.getEmails()
				.contains("vincentdevillers@hotmail.fr"));
		assertTrue(cardPerso.getPhones().contains(
				new Phone("MOBILE", "France", "+33", "0615053430")));

		mockServer.verify();
	}

	@Test
	public void getContactCardsForId() {
		mockServer
				.expect(requestTo(URIBuilder
						.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/contact_cards?access_token=ACCESS_TOKEN")
						.build()))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								jsonResource("testdata/contact-cards-for-id"),
								responseHeaders));

		List<ContactCards> contactCards = viadeo.userOperations()
				.getContactCards("EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(contactCards);
		assertEquals(2, contactCards.size());

		ContactCards cardBusiness = contactCards.get(0);
		assertEquals("ticctDfItsvkatamzkruyuxstnwOOIowEcyVghfhbluVfsElvmdk",
				cardBusiness.getId());
		assertEquals("BUSINESS", cardBusiness.getKind());
		assertEquals("Garches", cardBusiness.getCity());
		assertEquals("92", cardBusiness.getPostcode());
		assertEquals("France", cardBusiness.getCountry());
		assertTrue(cardBusiness.getEmails().contains(
				"vincentdevillers@hotmail.fr"));
		assertTrue(cardBusiness.getPhones().contains(
				new Phone("MOBILE", "France", "+33", "0615053430")));

		ContactCards cardPerso = contactCards.get(1);
		assertEquals("IqsmeqAbllyupOxwpkdkkdVtAndoxjcrntDhwvvmrInbmOVmIryk",
				cardPerso.getId());
		assertEquals("PERSO", cardPerso.getKind());
		assertEquals("Garches", cardPerso.getCity());
		assertEquals("92", cardPerso.getPostcode());
		assertEquals("France", cardPerso.getCountry());
		assertEquals("Ile-de-France", cardPerso.getRegion());
		assertTrue(cardPerso.getEmails()
				.contains("vincentdevillers@hotmail.fr"));
		assertTrue(cardPerso.getPhones().contains(
				new Phone("MOBILE", "France", "+33", "0615053430")));

		mockServer.verify();
	}

	@Test
	public void getCurrentInboxMessages() {
		mockServer
				.expect(
						requestTo(URIBuilder.fromUri(
								"https://api.viadeo.com/me/inbox?access_token=ACCESS_TOKEN&user_detail=full&limit=50").build()))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/inbox-messages-for-me"), responseHeaders));

		List<InboxMessage> inboxMessages = viadeo.userOperations().getInboxMessages();
		assertNotNull(inboxMessages);
		assertEquals(2, inboxMessages.size());

		InboxMessage message = inboxMessages.get(0);
		assertEquals("pvtweOoAcdjciVejhoDylwEjpmdavkvfatuVlqbmpvpucdbhhcAf", message.getId());
		assertEquals("http://www.viadeo.com/messages/detailsmessagerecu/?msgReceivedId=0021ahcgz6lyadff", message.getLink());
		assertEquals(Boolean.TRUE, message.getRead());
		assertEquals("RE : Message de test", message.getSubject());
		assertEquals("Bonjour Stéfanie\n\nMerci pour ton message, voici ma réponse.\nVincent",
				message.getMessage());
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", message.getSender().getId());
		assertEquals("Ile-de-France", message.getSender().getLocation().getArea());

		message = inboxMessages.get(1);
		assertEquals("cVVsvkzhhoIsguuVmVhmipblkkDjadxnoIfxkVADnnjmdwnEoDhf", message.getId());
		assertEquals("http://www.viadeo.com/messages/detailsmessagerecu/?msgReceivedId=0021gbk5t5ob6lff", message.getLink());
		assertEquals(Boolean.TRUE, message.getRead());
		assertEquals("Salut !!", message.getSubject());
		assertEquals("Salut,\n\nComment va? Ça se passe bien chez Viadeo? \n++ guillaume",
				message.getMessage());
		assertEquals("fuspVAkfvcOyOfyuekeOzvseDs", message.getSender().getId());
		assertEquals("Ile-de-France", message.getSender().getLocation().getArea());

		mockServer.verify();
	}
}
