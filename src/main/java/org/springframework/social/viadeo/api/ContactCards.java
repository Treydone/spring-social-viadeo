/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.viadeo.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ContactCards implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -898137483478431547L;

	private final String id;

	private String kind;

	private String city;

	private String postcode;

	private String country;

	private String region;

	private List<String> emails;

	private List<Phone> phones;

	private Date updatedTime;

	private String shared;

	private String companyAdress;

	private List<String> websites;

	public ContactCards(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getShared() {
		return shared;
	}

	public void setShared(String shared) {
		this.shared = shared;
	}

	public String getCompanyAdress() {
		return companyAdress;
	}

	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}

	public List<String> getWebsites() {
		return websites;
	}

	public void setWebsites(List<String> websites) {
		this.websites = websites;
	}

}
