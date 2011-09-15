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
import java.util.List;

import org.springframework.social.viadeo.api.Group;
import org.springframework.social.viadeo.api.GroupOperations;

public class GroupTemplate extends AbstractViadeoOperations implements
 GroupOperations {

	public GroupTemplate(ViadeoTemplate viadeoTemplate, boolean isAuthorized) {
		super(viadeoTemplate, isAuthorized);
	}

	@Override
	public List<Group> search(String query) {
		requireAuthorization();
		URI uri = buildUri("search/groups").queryParam("q", query).queryParam(
				"limit", "50").build();
		return get(uri, GroupsResult.class).getGroups();
	}

	@Override
	public Group getGroup(String objectId) {
		requireAuthorization();
		return get(objectId, Group.class);
	}
}
