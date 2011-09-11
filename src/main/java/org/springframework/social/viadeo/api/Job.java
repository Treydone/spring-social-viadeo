package org.springframework.social.viadeo.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class representing a job.
 */
public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7515333851500215109L;

	private final String id;

	private final String name;

	private final String link;

	private final Date updatedDate;

	private String title;

	private String description;

	private String category;

	private String experience;

	private String reference;

	public Job(String id, String name, String link, Date updatedDate) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
