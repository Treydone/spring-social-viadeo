package org.springframework.social.viadeo.api.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.viadeo.api.Job;



public class JobsResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6183916769172344982L;
	
	private final List<Job> jobs;

	public List<Job> getJobs() {
		return jobs;
	}

	public JobsResult(List<Job> jobs) {
		this.jobs = jobs;
	}
	
}
