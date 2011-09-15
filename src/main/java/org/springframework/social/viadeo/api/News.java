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

import org.springframework.social.viadeo.api.impl.Comments;

/**
 * Model class representing an entry in a feed.
 */
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489468015293993653L;

	private final String id;

	private final String message;

	private final ViadeoProfile from;

	private final Date creationDate;

	private final Date updatedDate;

	private String label;

	private Comments comments;

	public News(String id, String message, ViadeoProfile from,
			Date creationDate, Date updatedDate) {
		this.id = id;
		this.message = message;
		this.from = from;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}
}
