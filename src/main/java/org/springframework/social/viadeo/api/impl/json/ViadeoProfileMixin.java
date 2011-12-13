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
 * Annotated mixin to add Jackson annotations to ViadeoProfile.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ViadeoProfileMixin {

	@JsonCreator
	ViadeoProfileMixin(@JsonProperty("id") String id,
			@JsonProperty("gender") String gender,
			@JsonProperty("first_name") String firstName,
			@JsonProperty("last_name") String lastName,
			@JsonProperty("nickname") String nickName,
			@JsonProperty("link") String profileUrl,
			@JsonProperty("picture_large") String imageUrl) {
	}

	@JsonProperty("name")
	String name;

	@JsonProperty("contact_count")
	Long contactCount;

	@JsonProperty("distance")
	int distance;

	@JsonProperty("headline")
	String headline;

	@JsonProperty("interests")
	String interests;

	@JsonProperty("picture_small")
	String smallImageUrl;

	@JsonProperty("introduction")
	String introduction;

	@JsonProperty("language")
	String language;

	@JsonProperty("updated_time")
	Date updatedTime;

	@JsonProperty("has_picture")
	boolean hasPicture;

	@JsonProperty("is_premium")
	boolean isPremium;

	@JsonProperty("premium_since")
	Date premiumSince;
}
