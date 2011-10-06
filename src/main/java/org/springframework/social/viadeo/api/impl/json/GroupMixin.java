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
package org.springframework.social.viadeo.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to Group.
 */
@JsonIgnoreProperties({ "type" })
abstract class GroupMixin {

	@JsonCreator
	GroupMixin(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("link") String link, @JsonProperty("updated_time") Date updatedDate) {
	}

	@JsonProperty("access")
	String access;

	@JsonProperty("member_count")
	Integer memberCount;

	@JsonProperty("Description")
	String description;

	@JsonProperty("keywords")
	String keywords;

	@JsonProperty("country")
	String country;

	@JsonProperty("is_administrator")
	Boolean isAdmin;

}
