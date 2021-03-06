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
package org.springframework.social.viadeo.api.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.viadeo.api.InboxMessage;

public class InboxMessagesResult implements Serializable {

	private static final long serialVersionUID = 680503605687489167L;

	private final List<InboxMessage> inboxMessages;

	public List<InboxMessage> getInboxMessages() {
		return inboxMessages;
	}

	public InboxMessagesResult(List<InboxMessage> inboxMessages) {
		this.inboxMessages = inboxMessages;
	}

}
