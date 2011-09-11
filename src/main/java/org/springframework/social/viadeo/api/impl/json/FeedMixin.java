package org.springframework.social.viadeo.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.viadeo.api.News;


/**
 * Annotated mixin to add Jackson annotations to Feed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FeedMixin {

	@JsonCreator
	FeedMixin(@JsonProperty("data") List<News> news) {
	}

}
