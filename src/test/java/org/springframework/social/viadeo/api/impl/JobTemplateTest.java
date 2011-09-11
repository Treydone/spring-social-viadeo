package org.springframework.social.viadeo.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.viadeo.api.Job;

public class JobTemplateTest extends AbstractViadeoApiTest {

	@Test
	public void searchJobs() {
		mockServer.expect(requestTo("https://api.viadeo.com/search/jobs?access_token=ACCESS_TOKEN&q=java&limit=50"))
				.andExpect(method(GET)).andRespond(withResponse(jsonResource("testdata/job-search"), responseHeaders));

		List<Job> jobs = viadeo.jobOperations().search("java");
		assertEquals(50, jobs.size());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void searchJobs_unauthorized() {
		unauthorizedViadeo.jobOperations().search("java");
	}

	@Test
	public void getJobWithAndId() {
		mockServer.expect(requestTo("https://api.viadeo.com/hEVdvbpdwpmtumjAmIhnhuzbhA?access_token=ACCESS_TOKEN"))
				.andExpect(method(GET)).andRespond(withResponse(jsonResource("testdata/detailled-job"), responseHeaders));

		Job job = viadeo.jobOperations().getJob("hEVdvbpdwpmtumjAmIhnhuzbhA");

		assertEquals("hEVdvbpdwpmtumjAmIhnhuzbhA", job.getId());
		assertEquals("Graduate", job.getExperience());
		assertEquals("Informatique  -  Reseaux - Telecoms - Internet", job.getCategory());
		assertEquals("DEVELOPPEURS H/F", job.getTitle());
		assertEquals("", job.getName());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getJobWithAndId_unauthorized() {
		unauthorizedViadeo.jobOperations().getJob("hEVdvbpdwpmtumjAmIhnhuzbhA");
	}
}
