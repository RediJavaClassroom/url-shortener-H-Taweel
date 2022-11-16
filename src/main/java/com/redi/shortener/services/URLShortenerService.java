package com.redi.shortener.services;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.model.ExpandShortURLResponse;
import com.redi.shortener.persistence.URLShortened;
import com.redi.shortener.repository.URLShortenerRepository;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {

  @Autowired
  private URLShortenerRepository urlShortenerRepository;
  public CreateShortURLResponse create(final CreateShortURLRequest request, LocalDate validUntil)
      throws MalformedURLException {

    String domainName = "http://localhost:8080/";

    //    if (urlsDB.containsValue(request.url())) {
    //      UUID w = urlsDB.get(request.url());
    //      URL shortURL = new URL(domainName + w);
    //      return new CreateShortURLResponse(shortURL);
    //    }
    final String identifier = RandomStringUtils.randomAlphanumeric(7);
    final URI shortURL = URI.create(domainName + identifier);
    validUntil = LocalDate.now().plusDays(3);
    final URLShortened urlShortened = new URLShortened();
    urlShortened.setUrl(request.url().toString());
    urlShortened.setKey(identifier);
    urlShortenerRepository.save(urlShortened);

    return new CreateShortURLResponse(shortURL, validUntil);
  }

  public ExpandShortURLResponse expand(final String shortURLKey) throws URISyntaxException {
    //      if (urlsDB.containsKey(request.shortURLKey())){
    //          urlsDB.get(request.shortURLKey());
    //      }
    final URLShortened longURL = urlShortenerRepository.getURLShortenedByKey(shortURLKey);
    final URI response = new URI(longURL.getUrl());
    return new ExpandShortURLResponse(response);
  }
}
