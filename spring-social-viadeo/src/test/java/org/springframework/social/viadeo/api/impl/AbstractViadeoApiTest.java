package org.springframework.social.viadeo.api.impl;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.social.viadeo.api.impl.ViadeoTemplate;

public abstract class AbstractViadeoApiTest {
	protected static final String ACCESS_TOKEN = "ACCESS_TOKEN";

	protected ViadeoTemplate viadeo;
	protected ViadeoTemplate unauthorizedViadeo;
	protected MockRestServiceServer mockServer;
	protected HttpHeaders responseHeaders;

	@Before
	public void setup() {
		viadeo = new ViadeoTemplate(ACCESS_TOKEN);
		unauthorizedViadeo = new ViadeoTemplate();
		mockServer = MockRestServiceServer.createServer(viadeo
				.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		MockRestServiceServer
				.createServer(unauthorizedViadeo.getRestTemplate());
	}

	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}
}
