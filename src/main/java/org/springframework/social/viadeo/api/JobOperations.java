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
package org.springframework.social.viadeo.api;

import java.util.List;

public interface JobOperations {

	/**
	 * Search a job offer on viadeo.
	 * 
	 * @param query a group on a keyword.
	 * @return a list of job
	 */
	List<Job> search(String query);

	/**
	 * Retrieve the detail for a job offer.
	 * 
	 * @param objectId the id of the job
	 * @return the detailled job
	 */
	Job getJob(String objectId);
}
