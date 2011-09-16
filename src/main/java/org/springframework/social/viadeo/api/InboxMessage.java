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
 * Model class representing an inbox message.
 */
public class InboxMessage implements Serializable {

	private static final long serialVersionUID = -4441796285415315341L;

	private final String id;

	private final String name;

	private final String link;

	private final Date updatedDate;

	private Boolean read;

	private String subject;

	private String message;

	private ViadeoProfile sender;

	private List<ViadeoProfile> receivers;

	public InboxMessage(String id, String name, String link, Date updatedDate) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ViadeoProfile getSender() {
		return sender;
	}

	public void setSender(ViadeoProfile sender) {
		this.sender = sender;
	}

	public List<ViadeoProfile> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<ViadeoProfile> receivers) {
		this.receivers = receivers;
	}

}
