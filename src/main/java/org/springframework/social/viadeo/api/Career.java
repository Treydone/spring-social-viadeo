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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Model class representing the career of a member.
 */
public class Career implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4448688201536453749L;

	private final List<Experience> experiences;
	
	private Date updatedTime;

	public Career(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
}
