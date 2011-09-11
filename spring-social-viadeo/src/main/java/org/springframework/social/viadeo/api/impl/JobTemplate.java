package org.springframework.social.viadeo.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.viadeo.api.Job;
import org.springframework.social.viadeo.api.JobOperations;

public class JobTemplate extends AbstractViadeoOperations implements
		JobOperations {

	public JobTemplate(ViadeoTemplate viadeoTemplate, boolean isAuthorized) {
		super(viadeoTemplate, isAuthorized);
	}

	public List<Job> search(String query) {
		requireAuthorization();
		URI uri = buildUri("search/jobs").queryParam("q", query).queryParam(
				"limit", "50").build();
		return get(uri, JobsResult.class).getJobs();
	}

	public Job getJob(String objectId) {
		requireAuthorization();
		return get(objectId, Job.class);
	}
}
