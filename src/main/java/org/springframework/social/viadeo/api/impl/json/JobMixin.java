package org.springframework.social.viadeo.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to Job.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class JobMixin {

	@JsonCreator
	JobMixin(@JsonProperty("id") String id, @JsonProperty("name") String name,
			@JsonProperty("link") String link,
			@JsonProperty("updated_time") Date updatedDate) {
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

}
