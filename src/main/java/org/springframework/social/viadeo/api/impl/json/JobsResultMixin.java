package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.Job;


@JsonIgnoreProperties(ignoreUnknown = true)
abstract class JobsResultMixin {

	@JsonCreator
	JobsResultMixin(@JsonProperty("data") List<Job> jobs) {
	}
}
