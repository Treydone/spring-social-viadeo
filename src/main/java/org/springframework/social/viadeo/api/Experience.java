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

/**
 * Model class representing an experience in the career of a member.
 */
public class Experience implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4912758692634536937L;

	private final String id;
	
	private final String position;
	
	private final String description;
	
	private final String companyName;
	
	private Integer beginYear;
	
	private Integer endYear;
	
	private Date updatedTime;
	
	public Experience(String id, String position, String description,
			String companyName) {
		this.id = id;
		this.position = position;
		this.description = description;
		this.companyName = companyName;
	}

	public Integer getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(Integer beginYear) {
		this.beginYear = beginYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public String getId() {
		return id;
	}

	public String getPosition() {
		return position;
	}

	public String getDescription() {
		return description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
