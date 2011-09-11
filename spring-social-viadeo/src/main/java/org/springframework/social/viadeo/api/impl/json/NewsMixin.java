package org.springframework.social.viadeo.api.impl.json;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.ViadeoProfile;
import org.springframework.social.viadeo.api.impl.Comments;


/**
 * Annotated mixin to add Jackson annotations to News.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class NewsMixin {

	@JsonCreator
	NewsMixin(@JsonProperty("id") String id,
			@JsonProperty("message") String message,
			@JsonProperty("from") ViadeoProfile from,
			@JsonProperty("creation_date") Date creationDate,
			@JsonProperty("updated_time") Date updatedDate) {
	}

	@JsonProperty("comments")
	Comments comments;

}
