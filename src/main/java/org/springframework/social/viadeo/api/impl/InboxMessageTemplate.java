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

import java.net.URI;

import org.springframework.social.viadeo.api.InboxMessage;
import org.springframework.social.viadeo.api.InboxMessageOperations;

public class InboxMessageTemplate extends AbstractViadeoOperations implements InboxMessageOperations {

	public InboxMessageTemplate(ViadeoTemplate viadeoTemplate, boolean isAuthorized) {
		super(viadeoTemplate, isAuthorized);
	}

	@Override
	public InboxMessage getInboxMessage(String objectId) {
		requireAuthorization();
		URI uri = buildUri(objectId).queryParam(USER_DETAIL, FULL).build();
		return get(uri, InboxMessage.class);
	}

}
