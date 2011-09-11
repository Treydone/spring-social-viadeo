package org.springframework.social.viadeo.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.social.viadeo.api.JobOperations;
import org.springframework.social.viadeo.api.UserOperations;
import org.springframework.social.viadeo.api.Viadeo;
import org.springframework.social.viadeo.api.impl.json.ViadeoModule;

public class ViadeoTemplate extends AbstractOAuth2ApiBinding implements Viadeo {

	private UserOperations userOperations;

	private JobOperations jobOperations;

	private final String accessToken;

	/**
	 * Create a new instance of ViadeoTemplate. This constructor creates a new
	 * ViadeoTemplate able to perform unauthenticated operations against
	 * ViadeoTemplate's Graph API. Some operations do not require OAuth
	 * authentication. For example, retrieving a specified user's profile does
	 * not require authentication (although the data returned will be limited to
	 * what is publicly available). A ViadeoTemplate created with this
	 * constructor will support those operations. Those operations requiring
	 * authentication will throw {@link NotAuthorizedException}.
	 */
	public ViadeoTemplate() {
		this(null);
		initialize();
	}

	/**
	 * Create a new instance of ViadeoTemplate. This constructor creates the
	 * ViadeoTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Viadeo after a successful OAuth 2
	 *            authentication.
	 */
	public ViadeoTemplate(String accessToken) {
		super(accessToken);

		this.accessToken = accessToken;
		initialize();
	}

	private void initialize() {
		registerViadeoJsonModule();
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}

	private void initSubApis() {
		// sub-apis
		userOperations = new UserTemplate(this, isAuthorized());
		jobOperations = new JobTemplate(this, isAuthorized());
	}

	private void registerViadeoJsonModule() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new ViadeoModule());

		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>(1);
		supportedMediaTypes.add(MediaType.ALL);

		List<HttpMessageConverter<?>> converters = getRestTemplate()
				.getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
				jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
				jsonConverter.setObjectMapper(objectMapper);
			}
		}
	}

	public URIBuilder withAccessToken(String uri) {
		return (accessToken == null) ? URIBuilder.fromUri(uri) : URIBuilder
				.fromUri(uri).queryParam("access_token", accessToken);
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	public JobOperations jobOperations() {
		return jobOperations;
	}

}
