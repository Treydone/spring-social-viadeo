package org.springframework.social.viadeo.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.viadeo.api.Viadeo;

/**
 * Viadeo ConnectionFactory implementation.
 * 
 * @author Vincent Devillers
 */
public class ViadeoConnectionFactory extends OAuth2ConnectionFactory<Viadeo> {

	public ViadeoConnectionFactory(String clientId, String clientSecret) {
		super("viadeo", new ViadeoServiceProvider(clientId, clientSecret),
				new ViadeoAdapter());
	}

}