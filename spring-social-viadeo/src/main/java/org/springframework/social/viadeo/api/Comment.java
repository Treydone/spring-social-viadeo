package org.springframework.social.viadeo.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class representing a comment.
 */
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 912290621852237147L;

	private final String id;
	
	private final String message;
	
	private final ViadeoProfile from;
	
	private final Date createdDate;

	public Comment(String id, String message, ViadeoProfile from,
			Date createdDate) {
		this.id = id;
		this.message = message;
		this.from = from;
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public ViadeoProfile getFrom() {
		return from;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
}
