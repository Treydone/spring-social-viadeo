package org.springframework.social.viadeo.api;

import org.springframework.social.SocialException;

/**
 * Exception thrown when a Graph API usage error (such as an unknown connection
 * path) occurs.
 */
@SuppressWarnings("serial")
public class GraphAPIException extends SocialException {

	public GraphAPIException(String message) {
		super(message);
	}

	public GraphAPIException(String message, Throwable e) {
		super(message, e);
	}

}
