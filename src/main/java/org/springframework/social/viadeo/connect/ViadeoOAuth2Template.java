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
package org.springframework.social.viadeo.connect;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

/**
 * Viadeo-specific extension of OAuth2Template to use a RestTemplate that
 * recognizes form-encoded responses as "application/x-www-form-urlencoded".
 * Viadeo token responses are form-encoded results with a content type of
 * "application/x-www-form-urlencoded", which prevents the
 * FormHttpMessageConverter registered by default from parsing the results.
 * 
 * @author Vincent Devillers
 */
public class ViadeoOAuth2Template extends OAuth2Template {

	public ViadeoOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret,
				"https://secure.viadeo.com/oauth-provider/authorize2",
				"https://secure.viadeo.com/oauth-provider/access_token2");
	}

	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(
				ClientHttpRequestFactorySelector.getRequestFactory());
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(
				2);
		converters.add(new FormHttpMessageConverter());

		AbstractHttpMessageConverter<?> jsonConverter = new MappingJacksonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>(3);
		supportedMediaTypes.add(new MediaType("application", "json", Charset
				.forName("UTF-8")));
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		jsonConverter.setSupportedMediaTypes(supportedMediaTypes);

		converters.add(jsonConverter);
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}
}