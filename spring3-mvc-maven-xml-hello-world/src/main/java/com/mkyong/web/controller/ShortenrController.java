package com.mkyong.web.controller;

import java.util.Dictionary;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.urlshortener.models.ShortenedUrlModel;
import com.urlshortener.models.UrlModel;

@Controller()
@RequestMapping("/shorten")
public class ShortenrController {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = ALPHABET.length();

	private Dictionary<Long, ShortenedUrlModel> shortenedUrls;
	private AtomicLong count = new AtomicLong(0);

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		// convert shortName to int, then get value
		return "arao test";
	}

	// get
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getFullUrl(@PathVariable("short") String shortName) {
		// convert shortName to int, then get value
		long id = 0;
		int i = 0;
		while (i < shortName.length()) {
			id = id * BASE + ALPHABET.indexOf(shortName.charAt(i));
			i++;
		}
		return shortenedUrls.get(id).urlModel.url;
	}

	// post
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postNewUrl(@RequestBody UrlModel urlModel) {
		ShortenedUrlModel shortUrlModel = new ShortenedUrlModel();
		shortUrlModel.urlModel = urlModel;
		StringBuilder sb = new StringBuilder();
		long id = count.getAndIncrement();
		long i = id;
		do {
			sb.append(ALPHABET.charAt((int) i % BASE));
			i = i / BASE;
		} while (i > 0);
		sb.reverse();
		shortUrlModel.shortUrl = sb.toString();
		shortenedUrls.put(id, shortUrlModel);
		return shortUrlModel.shortUrl;
	}

	// delete
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteUrl(@PathVariable("short") String shortName) {
		long id = 0;
		int i = 0;
		while (i < shortName.length()) {
			id = id * BASE + ALPHABET.indexOf(shortName.charAt(i));
			i++;
		}
		shortenedUrls.remove(id);
	}
}
