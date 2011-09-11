package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.ViadeoProfile;


/**
 * Annotated mixin to add Jackson annotations to Contacts.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ContactsMixin {

	@JsonCreator
	ContactsMixin(@JsonProperty("data") List<ViadeoProfile> contacts) {
	}

}
