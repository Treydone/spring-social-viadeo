package org.springframework.social.viadeo.api;

import java.io.Serializable;

/**
 * Model class representing an experience in the career of a member.
 */
public class Experience implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4912758692634536937L;

	private final String id;
	
	private final String position;
	
	private final String description;
	
	private final String companyName;
	
	private Integer beginYear;
	
	private Integer endYear;

	public Experience(String id, String position, String description,
			String companyName) {
		this.id = id;
		this.position = position;
		this.description = description;
		this.companyName = companyName;
	}

	public Integer getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(Integer beginYear) {
		this.beginYear = beginYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public String getId() {
		return id;
	}

	public String getPosition() {
		return position;
	}

	public String getDescription() {
		return description;
	}

	public String getCompanyName() {
		return companyName;
	}
}
