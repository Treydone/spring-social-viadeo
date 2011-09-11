package org.springframework.social.viadeo.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.viadeo.api.Viadeo;


public class ViadeoConnectionFactory extends OAuth2ConnectionFactory<Viadeo> {

	public ViadeoConnectionFactory(String clientId, String clientSecret) {
		super("viadeo", new ViadeoServiceProvider(clientId, clientSecret), new ViadeoAdapter());
	}
	
}