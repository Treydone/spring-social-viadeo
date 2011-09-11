package org.springframework.social.viadeo.api.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.viadeo.api.Comment;


public class Comments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8748950763266683264L;

	private final List<Comment> comments;

	public Comments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

}
