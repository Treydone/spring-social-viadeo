package org.springframework.social.viadeo.api;

import java.util.List;

public interface JobOperations {

	/**
	 * Search a job offer on viadeo.
	 * 
	 * @param query
	 *            a group on a keyword.
	 * @return a list of job
	 */
	List<Job> search(String query);

	/**
	 * Retrieve the detail for a job offer.
	 * 
	 * @param objectId
	 *            the id of the job
	 * @return the detailled job
	 */
	Job getJob(String objectId);
}
