package org.springframework.social.viadeo.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to Location.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class LocationMixin {

	@JsonCreator
	LocationMixin() {
	}

	@JsonProperty("city")
	String city;

	@JsonProperty("zipcode")
	String zipcode;

	@JsonProperty("country")
	String country;

	@JsonProperty("area")
	String area;

	@JsonProperty("timezone")
	String timezone;

	@JsonProperty("latitude")
	String latitude;

	@JsonProperty("longitude")
	String longitude;
}
