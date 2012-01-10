/*
* Copyright 2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.springframework.social.viadeo.api.impl;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.viadeo.api.GraphAPIException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;

abstract class AbstractViadeoOperations {

	static final String LIMIT = "limit";

	static final String PAGE = "page";

	static final String FULL = "full";

	static final String ME = "me";

	static final String USER_DETAIL = "user_detail";

	static final String GRAPH_API_URL = "https://api.viadeo.com/";

	static final String OBJECT_URL = GRAPH_API_URL + "{objectId}";

	private final boolean isAuthorized;

	protected final ViadeoTemplate viadeoTemplate;

	public AbstractViadeoOperations(ViadeoTemplate viadeoTemplate, boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
		this.viadeoTemplate = viadeoTemplate;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}

	protected URIBuilder buildUri(String path, Map<String, String> params) {
		URIBuilder uriBuilder = viadeoTemplate.withAccessToken(GRAPH_API_URL + path);
		for (String paramName : params.keySet()) {
			uriBuilder.queryParam(paramName, String.valueOf(params.get(paramName)));
		}
		return uriBuilder;
	}

	protected URIBuilder buildUri(String path) {
		return buildUri(path, Collections.<String, String> emptyMap());
	}

	protected <T> T get(URI uri, Class<T> responseType) {
		return viadeoTemplate.getRestTemplate().getForObject(uri, responseType);
	}

	public <T> T get(String objectId, Class<T> type) {
		try {
			URI uri = buildUri(objectId).build();
			return get(uri, type);
		} catch (ResourceAccessException e) {
			// Handle the special case where an unknown alias results in an
			// error returned as a HTTP 200
			if (e.getCause() instanceof UnrecognizedPropertyException) {
				UnrecognizedPropertyException jsonException = (UnrecognizedPropertyException) e.getCause();
				if (jsonException.getUnrecognizedPropertyName().equals("error")) {
					throw new GraphAPIException("Unknown alias: " + objectId);
				}
			}
			throw new GraphAPIException("Unexpected graph API exception", e.getCause());
		}
	}

	protected <C> C post(URI uri, MultiValueMap<String, String> data, Class<C> responseType) {
		MultiValueMap<String, String> requestData = new LinkedMultiValueMap<String, String>(data);
		return viadeoTemplate.getRestTemplate().postForObject(uri, requestData, responseType);
	}
}
