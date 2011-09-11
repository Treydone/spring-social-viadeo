package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.Phone;

/**
 * Annotated mixin to add Jackson annotations to ContactCards.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ContactCardsMixin {

	@JsonCreator
	ContactCardsMixin(@JsonProperty("id") String id) {
	}
	
	@JsonProperty("kind")
	String kind;
	
	@JsonProperty("city")
	String city;

	@JsonProperty("postcode")
	String postcode;

	@JsonProperty("country")
	String country;

	@JsonProperty("region")
	String region;

	@JsonProperty("emails")
	List<String> emails;

	@JsonProperty("phones")
	List<Phone> phones;

}
