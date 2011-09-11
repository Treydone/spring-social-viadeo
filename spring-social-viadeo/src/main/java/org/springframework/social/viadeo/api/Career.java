package org.springframework.social.viadeo.api;

import java.io.Serializable;
import java.util.List;

/**
 * Model class representing the career of a member.
 */
public class Career implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4448688201536453749L;

	private final List<Experience> experiences;

	public Career(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}
	
}
