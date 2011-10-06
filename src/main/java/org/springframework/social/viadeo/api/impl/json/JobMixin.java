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
import org.springframework.social.viadeo.api.Company;
import org.springframework.social.viadeo.api.Location;

/**
 * Annotated mixin to add Jackson annotations to Job.
 */
@JsonIgnoreProperties({"type", "name"})
abstract class JobMixin {

	@JsonCreator
	JobMixin(@JsonProperty("id") String id, @JsonProperty("link") String link, @JsonProperty("updated_time") Date updatedDate) {
	}

	@JsonProperty("title")
	String title;

	@JsonProperty("description")
	String description;

	@JsonProperty("category")
	String category;

	@JsonProperty("experience")
	String experience;

	@JsonProperty("reference")
	String reference;

	@JsonProperty("location")
	Location location;

	@JsonProperty("education_level")
	String educationLevel;

	@JsonProperty("contract_type")
	String contractType;
	
	@JsonProperty("company_info")
	Company company;
}
