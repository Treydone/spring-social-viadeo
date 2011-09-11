package org.springframework.social.viadeo.api;

import java.io.Serializable;

/**
 * Model class containing a user's Viadeo profile information.
 * 
 */
public class ViadeoProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1973974445859297954L;

	private final String id;

	private final String gender;

	private final String firstName;

	private final String lastName;

	private final String nickName;

	private final String profileUrl;

	private final String largeImageUrl;

	private String smallImageUrl;

	private String headline;

	private String interests;

	private Long contactCount;

	public ViadeoProfile(String id, String gender, String firstName,
			String lastName, String nickName, String profileUrl,
			String largeImageUrl) {
		this.id = id;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.profileUrl = profileUrl;
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * The user's Viadeo profile ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getGender() {
		return gender;
	}

	public Long getContactCount() {
		return contactCount;
	}

	public void setContactCount(Long contactCount) {
		this.contactCount = contactCount;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
}
