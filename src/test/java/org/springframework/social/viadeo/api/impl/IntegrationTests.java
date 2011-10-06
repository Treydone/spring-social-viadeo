package org.springframework.social.viadeo.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.viadeo.api.Job;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.ViadeoProfile;

public class IntegrationTests {

	private static ViadeoTemplate viadeo;

	private static ViadeoTemplate unauthorizedViadeo;

	@BeforeClass
	public static void beforeClass() {
		String token = System.getProperty("token");
		if (StringUtils.isBlank(token)) {
			throw new IllegalArgumentException("You must define the property 'token' when launching this test!");
		}
		viadeo = new ViadeoTemplate(token);
		unauthorizedViadeo = new ViadeoTemplate();
	}

	@Test
	public void getCurrentUser() {
		ViadeoProfile profile = viadeo.userOperations().getUserProfile();

		assertNotNull(profile);

		// Profile
		assertEquals("iysxlvmuDcqlxscsOdIurruIaw", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Homer", profile.getFirstName());
		assertEquals("Simpson", profile.getLastName());
		assertEquals("omer.simpson3", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/002ax59lzianvnt", profile.getProfileUrl());
		assertEquals(Long.valueOf(0), profile.getContactCount());

		// Pro
		assertEquals("", profile.getIntroduction());
		assertEquals("", profile.getInterests());
		assertEquals("fr", profile.getLanguage());
		assertEquals("Inspecteur de la sécurité, Centrale nucléaire de Springfield", profile.getHeadline());

		// Location
		assertEquals("Springfield", profile.getLocation().getCity());
		assertEquals("", profile.getLocation().getZipcode());
		assertEquals("Etats-Unis", profile.getLocation().getCountry());
		assertEquals("non précisée", profile.getLocation().getArea());
		assertEquals("", profile.getLocation().getTimezone());
		assertEquals("", profile.getLocation().getLatitude());
		assertEquals("", profile.getLocation().getLongitude());
	}

	@Test(expected = NotAuthorizedException.class)
	public void getCurrentUser_unauthorized() {
		unauthorizedViadeo.userOperations().getUserProfile();
	}

	@Test
	public void getUserProfileById() throws ParseException {

		ViadeoProfile profile = unauthorizedViadeo.userOperations().getUserProfile("iysxlvmuDcqlxscsOdIurruIaw");

		assertNotNull(profile);

		// Profile
		assertEquals("iysxlvmuDcqlxscsOdIurruIaw", profile.getId());
		assertEquals("M", profile.getGender());
		assertEquals("Homer", profile.getFirstName());
		assertEquals("Simpson", profile.getLastName());
		assertEquals("omer.simpson3", profile.getNickName());
		assertEquals("http://www.viadeo.com/profile/002ax59lzianvnt", profile.getProfileUrl());
		assertEquals(Long.valueOf(0), profile.getContactCount());

		// Pro
		assertEquals("", profile.getIntroduction());
		assertEquals("", profile.getInterests());
		assertEquals("fr", profile.getLanguage());
		assertEquals("Inspecteur de la sécurité, Centrale nucléaire de Springfield", profile.getHeadline());

		// Location
		assertEquals("Springfield", profile.getLocation().getCity());
		assertEquals("", profile.getLocation().getZipcode());
		assertEquals("Etats-Unis", profile.getLocation().getCountry());
		assertEquals("non précisée", profile.getLocation().getArea());
		assertEquals("", profile.getLocation().getTimezone());
		assertEquals("", profile.getLocation().getLatitude());
		assertEquals("", profile.getLocation().getLongitude());
	}

	@Test(expected = NotAuthorizedException.class)
	public void updateStatus_unauthorized() {
		unauthorizedViadeo.userOperations().updateStatus("Mon nouveau status");
	}

	@Test(expected = IllegalArgumentException.class)
	public void updateStatus_statusTooLong() {
		viadeo.userOperations().updateStatus(
				"Veeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrryyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy" + " looooooooooooooooooooooooooooonnnnnnnnnnnnngggggg "
						+ "staaaaaaaaatuuuuuuuuuuuuuuuuuusssssssssssss");
	}

	@Test
	public void updateStatus() {
		int random = new Random().nextInt();
		viadeo.userOperations().updateStatus("Mon nouveau status:" + random);
		List<News> news = viadeo.userOperations().getNewsFeed();
		News firstNews = news.get(0);
		assertEquals("Status : ", firstNews.getLabel());
		assertEquals("Mon nouveau status:" + random, firstNews.getMessage());
	}

	@Test
	public void search() {
		List<ViadeoProfile> contacts = viadeo.userOperations().search("Vincent DEVILLERS");
		assertNotNull(contacts);
		assertEquals(50, contacts.size());
	}

	@Test(expected = NotAuthorizedException.class)
	public void search_unauthorized() {
		unauthorizedViadeo.userOperations().search("Vincent DEVILLERS");
	}

	@Test
	public void searchJobs() {

		List<Job> jobs = unauthorizedViadeo.jobOperations().search("java");
		assertEquals(50, jobs.size());

		unauthorizedViadeo.jobOperations().getJob(jobs.get(0).getId());
	}

}
