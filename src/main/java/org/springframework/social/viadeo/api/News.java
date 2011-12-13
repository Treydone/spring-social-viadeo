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

import org.springframework.social.viadeo.api.impl.Comments;
import org.springframework.social.viadeo.api.impl.Likes;

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

	private final Date createdTime;

	private final Date updatedTime;

	private String label;

	private Comments comments;
	
	private Likes likes;
	
	private String infeedLink;
	
	private String type;
	
	private List<String> tags;
	
	public News(String id, String message, ViadeoProfile from,
			Date createdTime, Date updatedTime) {
		this.id = id;
		this.message = message;
		this.from = from;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
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

	public String getInfeedLink() {
		return infeedLink;
	}

	public void setInfeedLink(String infeedLink) {
		this.infeedLink = infeedLink;
	}

	public Likes getLikes() {
		return likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
