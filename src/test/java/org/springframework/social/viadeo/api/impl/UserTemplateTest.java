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

import java.util.List;

import org.junit.Test;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.viadeo.api.ContactCards;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.Phone;
import org.springframework.social.viadeo.api.ViadeoProfile;

public class UserTemplateTest extends AbstractViadeoApiTest {

	@Test
	public void getCurrentUser() {
		mockServer.expect(requestTo("https://api.viadeo.com/me?access_token=ACCESS_TOKEN")).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/full-profile-me"), responseHeaders));

		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Vincent", profile.getFirstName());
		assertEquals("DEVILLERS", profile.getLastName());
		assertEquals("vincent.devillers1", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/0021g557w9j1iw4m", profile.getProfileUrl());
		assertEquals(Long.valueOf(146), profile.getContactCount());
		assertEquals("Karate (2eme Dan), piano, natation, apnee libre, robotique", profile.getInterests());
		assertEquals("Ingenieur d'etudes et de developpement, Viadeo", profile.getHeadline());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentUser_unauthorized() {
		unauthorizedViadeo.userOperations().getUserProfile();
	}

	@Test
	public void getUserProfileById() {
		mockServer.expect(requestTo("https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg?access_token=ACCESS_TOKEN"))
				.andExpect(method(GET)).andRespond(withResponse(jsonResource("testdata/full-profile-by-id"), responseHeaders));

		ViadeoProfile profile = viadeo.userOperations().getUserProfile("EjtftevbyiugaIfDfVizDgymxg");
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Vincent", profile.getFirstName());
		assertEquals("DEVILLERS", profile.getLastName());
		assertEquals("vincent.devillers1", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/0021g557w9j1iw4m", profile.getProfileUrl());
		assertEquals(Long.valueOf(146), profile.getContactCount());
		assertEquals("Karate (2eme Dan), piano, natation, apnee libre, robotique", profile.getInterests());
		assertEquals("Ingenieur d'etudes et de developpement, Viadeo", profile.getHeadline());
		mockServer.verify();
	}

	@Test
	public void getCurrentContacts() {
		mockServer
				.expect(
						requestTo(URIBuilder.fromUri(
								"https://api.viadeo.com/me/contacts?access_token=ACCESS_TOKEN&user_detail=full&limit=20").build()))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/full-contacts-for-me"), responseHeaders));

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
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/contacts?access_token=ACCESS_TOKEN&user_detail=full&limit=20")
								.build())).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/full-contacts-for-id"), responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().getContacts("EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(contacts);
		assertEquals(20, contacts.size());
		mockServer.verify();
	}

	@Test
	public void getCurrentNewsFeed() {
		mockServer
				.expect(
						requestTo(URIBuilder.fromUri(
								"https://api.viadeo.com/me/home_newsfeed?access_token=ACCESS_TOKEN&user_detail=full&limit=50").build()))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/full-home_newsfeed-for-me"), responseHeaders));

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
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/home_newsfeed?access_token=ACCESS_TOKEN&user_detail=full&limit=50")
								.build())).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/full-home_newsfeed-for-id"), responseHeaders));

		List<News> news = viadeo.userOperations().getNewsFeed("EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(news);
		assertEquals(10, news.size());
		mockServer.verify();
	}

	@Test
	public void getCurrentExperiences() {
		mockServer
				.expect(
						requestTo(URIBuilder.fromUri("https://api.viadeo.com/me/career?access_token=ACCESS_TOKEN&user_detail=full")
								.build())).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/career-for-me"), responseHeaders));

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
				.expect(
						requestTo(URIBuilder.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/career?access_token=ACCESS_TOKEN&user_detail=full")
								.build())).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/career-for-id"), responseHeaders));

		List<Experience> experiences = viadeo.userOperations().getExperiences("EjtftevbyiugaIfDfVizDgymxg");
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
		viadeo.userOperations().updateStatus(
				"Veeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
						+ " looooooooooooooooooooooooooooonnnnnnnnnnnnngggggg " + "staaaaaaaaatuuuuuuuuuuuuuuuuuusssssssssssss");
	}

	@Test
	public void updateStatus() {
		mockServer.expect(requestTo(URIBuilder.fromUri("https://api.viadeo.com/status?access_token=ACCESS_TOKEN").build()))
				.andExpect(method(POST)).andExpect(body("message=Mon+nouveau+status"))
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
				.expect(
						requestTo(URIBuilder
								.fromUri(
										"https://api.viadeo.com/search/users?access_token=ACCESS_TOKEN&user_detail=full&keyword=Vincent+DEVILLERS&limit=50")
								.build())).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/search-contacts"), responseHeaders));

		List<ViadeoProfile> contacts = viadeo.userOperations().search("Vincent DEVILLERS");
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
				.expect(
						requestTo(URIBuilder.fromUri("https://api.viadeo.com/me/contact_cards?access_token=ACCESS_TOKEN").build()))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/contact-cards-for-me"), responseHeaders));

		List<ContactCards> contactCards = viadeo.userOperations().getContactCards();
		assertNotNull(contactCards);
		assertEquals(2, contactCards.size());

		ContactCards cardBusiness = contactCards.get(0);
		assertEquals("ticctDfItsvkatamzkruyuxstnwOOIowEcyVghfhbluVfsElvmdk", cardBusiness.getId());
		assertEquals("BUSINESS", cardBusiness.getKind());
		assertEquals("Garches", cardBusiness.getCity());
		assertEquals("92", cardBusiness.getPostcode());
		assertEquals("France", cardBusiness.getCountry());
		assertTrue(cardBusiness.getEmails().contains("vincentdevillers@hotmail.fr"));
		assertTrue(cardBusiness.getPhones().contains(new Phone("MOBILE", "France", "+33", "0615053430")));

		ContactCards cardPerso = contactCards.get(1);
		assertEquals("IqsmeqAbllyupOxwpkdkkdVtAndoxjcrntDhwvvmrInbmOVmIryk", cardPerso.getId());
		assertEquals("PERSO", cardPerso.getKind());
		assertEquals("Garches", cardPerso.getCity());
		assertEquals("92", cardPerso.getPostcode());
		assertEquals("France", cardPerso.getCountry());
		assertEquals("Ile-de-France", cardPerso.getRegion());
		assertTrue(cardPerso.getEmails().contains("vincentdevillers@hotmail.fr"));
		assertTrue(cardPerso.getPhones().contains(new Phone("MOBILE", "France", "+33", "0615053430")));

		mockServer.verify();
	}

	@Test
	public void getContactCardsForId() {
		mockServer
				.expect(
						requestTo(URIBuilder.fromUri(
								"https://api.viadeo.com/EjtftevbyiugaIfDfVizDgymxg/contact_cards?access_token=ACCESS_TOKEN").build()))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/contact-cards-for-id"), responseHeaders));

		List<ContactCards> contactCards = viadeo.userOperations().getContactCards("EjtftevbyiugaIfDfVizDgymxg");
		assertNotNull(contactCards);
		assertEquals(2, contactCards.size());

		ContactCards cardBusiness = contactCards.get(0);
		assertEquals("ticctDfItsvkatamzkruyuxstnwOOIowEcyVghfhbluVfsElvmdk", cardBusiness.getId());
		assertEquals("BUSINESS", cardBusiness.getKind());
		assertEquals("Garches", cardBusiness.getCity());
		assertEquals("92", cardBusiness.getPostcode());
		assertEquals("France", cardBusiness.getCountry());
		assertTrue(cardBusiness.getEmails().contains("vincentdevillers@hotmail.fr"));
		assertTrue(cardBusiness.getPhones().contains(new Phone("MOBILE", "France", "+33", "0615053430")));

		ContactCards cardPerso = contactCards.get(1);
		assertEquals("IqsmeqAbllyupOxwpkdkkdVtAndoxjcrntDhwvvmrInbmOVmIryk", cardPerso.getId());
		assertEquals("PERSO", cardPerso.getKind());
		assertEquals("Garches", cardPerso.getCity());
		assertEquals("92", cardPerso.getPostcode());
		assertEquals("France", cardPerso.getCountry());
		assertEquals("Ile-de-France", cardPerso.getRegion());
		assertTrue(cardPerso.getEmails().contains("vincentdevillers@hotmail.fr"));
		assertTrue(cardPerso.getPhones().contains(new Phone("MOBILE", "France", "+33", "0615053430")));

		mockServer.verify();
	}
}
