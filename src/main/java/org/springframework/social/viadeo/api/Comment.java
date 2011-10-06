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
 * Model class representing a comment.
 */
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 912290621852237147L;

	private final String id;
	
	private final String message;
	
	private final ViadeoProfile from;
	
	private final Date createdTime;
	
	private Date updatedTime;
	
	private String privacy;
	
	public Comment(String id, String message, ViadeoProfile from,
			Date createdTime) {
		this.id = id;
		this.message = message;
		this.from = from;
		this.createdTime = createdTime;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public ViadeoProfile getFrom() {
		return from;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public String getPrivacy() {
		return privacy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	
}
