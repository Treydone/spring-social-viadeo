package org.springframework.social.viadeo.api.impl.json;

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
	
	@JsonProperty("contact_count")
	Long contactCount;
	
	@JsonProperty("headline")
	String headline;
	
	@JsonProperty("interests")
	String interests;

	@JsonProperty("picture_small")
	String smallImageUrl;
}
