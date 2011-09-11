package org.springframework.social.viadeo.api.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.viadeo.api.ContactCards;

public class VisitCards implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7349321974117003796L;

	private final List<ContactCards> contactCards;

	public VisitCards(List<ContactCards> contactCards) {
		this.contactCards = contactCards;
	}

	public List<ContactCards> getContactCards() {
		return contactCards;
	}
}
