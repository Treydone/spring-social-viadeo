package org.springframework.social.viadeo.api.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.social.viadeo.api.News;


public class Feed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4312798721744954030L;

	private final List<News> news;

	public Feed(List<News> news) {
		this.news = news;
	}

	public List<News> getNews() {
		return news;
	}
}
