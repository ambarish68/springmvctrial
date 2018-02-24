package com.urlshortener.models;

public class ShortenedUrlModel {
	public String shortUrl;
	public UrlModel urlModel;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public UrlModel getUrlModel() {
		return urlModel;
	}

	public void setUrlModel(UrlModel urlModel) {
		this.urlModel = urlModel;
	}
}
