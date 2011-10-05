package org.springframework.social.viadeo.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.social.viadeo.api.ViadeoProfile;

public class IntegrationTests {

	private static ViadeoTemplate template;

	@BeforeClass
	public static void beforeClass() {
		String token = System.getProperty("token");
		if (StringUtils.isBlank(token)) {
			throw new IllegalArgumentException("You must define the property 'token' when launching this test!");
		}
		template = new ViadeoTemplate(token);
	}

	@Test
	public void getCurrentUser() {
		ViadeoProfile profile = template.userOperations().getUserProfile();

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
}
