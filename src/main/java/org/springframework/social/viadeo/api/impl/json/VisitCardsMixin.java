package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.ContactCards;

/**
 * Annotated mixin to add Jackson annotations to VisitCards.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VisitCardsMixin {

	@JsonCreator
	VisitCardsMixin(@JsonProperty("data") List<ContactCards> contactCards) {
	}
}
