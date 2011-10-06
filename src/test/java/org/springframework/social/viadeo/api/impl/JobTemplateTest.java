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
import org.springframework.social.viadeo.api.Job;

public class JobTemplateTest extends AbstractViadeoApiTest {

	@Test
	public void searchJobs() {
		unauthorizedMockServer.expect(requestTo("https://api.viadeo.com/search/jobs?q=java&limit=50")).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/job-search"), responseHeaders));

		List<Job> jobs = unauthorizedViadeo.jobOperations().search("java");
		assertEquals(50, jobs.size());
		mockServer.verify();
	}

	@Test
	public void getJobWithAndId() {
		unauthorizedMockServer.expect(requestTo("https://api.viadeo.com/hEVdvbpdwpmtumjAmIhnhuzbhA")).andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/detailled-job"), responseHeaders));

		Job job = unauthorizedViadeo.jobOperations().getJob("hEVdvbpdwpmtumjAmIhnhuzbhA");

		assertEquals("hEVdvbpdwpmtumjAmIhnhuzbhA", job.getId());
		assertEquals("Graduate", job.getExperience());
		assertEquals("Informatique  -  Reseaux - Telecoms - Internet", job.getCategory());
		assertEquals("DEVELOPPEURS H/F", job.getTitle());
		mockServer.verify();
	}
}
