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
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.viadeo.api.Group;

public class GroupTemplateTest extends AbstractViadeoApiTest {

	@Test
	public void searchGroups() {
		mockServer.expect(requestTo("https://api.viadeo.com/search/groups?access_token=ACCESS_TOKEN&q=viadeo&limit=50")).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/group-search"), responseHeaders));

		List<Group> groups = viadeo.groupOperations().search("viadeo");
		assertEquals(50, groups.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void searchGroups_unauthorized() {
		unauthorizedViadeo.groupOperations().search("viadeo");
	}

	@Test
	public void getGroupWithAndId() {
		mockServer.expect(requestTo("https://api.viadeo.com/agvhhkokasejibsVdfvxdquioO?access_token=ACCESS_TOKEN")).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/detailed-group"), responseHeaders));

		Group group = viadeo.groupOperations().getGroup("agvhhkokasejibsVdfvxdquioO");

		assertEquals("agvhhkokasejibsVdfvxdquioO", group.getId());
		assertEquals("http://www.viadeo.com/groups/?containerId=0021d48ug5k1aubb", group.getLink());
		assertEquals("Viadeo 500+", group.getName());
		assertEquals("PUBLIC", group.getAccess());
		assertEquals(new Integer(138), group.getMemberCount());
		assertEquals("Hub des membres Viadeo ayant plus de 500 contacts directs", group.getDescription());
		assertEquals("500 contacts directs viaduc viadeo", group.getKeywords());
		assertEquals("fr", group.getCountry());
		assertEquals(Boolean.FALSE, group.getIsAdmin());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getGroupWithAndId_unauthorized() {
		unauthorizedViadeo.groupOperations().getGroup("agvhhkokasejibsVdfvxdquioO");
	}
}
