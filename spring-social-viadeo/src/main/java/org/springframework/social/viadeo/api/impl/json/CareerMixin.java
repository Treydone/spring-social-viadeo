package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.Experience;

/**
 * Annotated mixin to add Jackson annotations to Career.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CareerMixin {

	@JsonCreator
	CareerMixin(@JsonProperty("data") List<Experience> experiences) {
	}
}
