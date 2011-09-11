package org.springframework.social.viadeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Annotated mixin to add Jackson annotations to Phone.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhoneMixin {

	@JsonCreator
	PhoneMixin(@JsonProperty("type") String type,
			@JsonProperty("country") String country,
			@JsonProperty("dialing") String dialing,
			@JsonProperty("number") String number) {
	}
}
