package com.redi.shortener.services;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.model.ExpandShortURLResponse;
import com.redi.shortener.persistence.URLShortened;
import com.redi.shortener.repository.URLShortenerRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {

  @Autowired private URLShortenerRepository urlShortenerRepository;

  public CreateShortURLResponse create(final CreateShortURLRequest request) {

        if (! urlShortenerRepository.getURLShortenedByUrl(request.url().toString()).isEmpty()) {
          throw new RuntimeException("This URL already shortened");
        }
    final String domainName = "http://localhost:8080/";
    final String identifier = RandomStringUtils.randomAlphanumeric(7);
    final URI shortURL = URI.create(domainName + identifier);
//    final LocalDateTime validUntil = LocalDateTime.now().plusDays(3);
    final LocalDateTime validUntil = LocalDateTime.now().plusSeconds(15);
    final URLShortened urlShortened = new URLShortened();
    urlShortened.setUrl(request.url().toString());
    urlShortened.setKey(identifier);
    urlShortened.setValidUntil(validUntil);
    urlShortenerRepository.save(urlShortened);

    return new CreateShortURLResponse(shortURL, validUntil);
  }

  public ExpandShortURLResponse expand(final String shortURLKey) throws URISyntaxException {

    final URLShortened longURL = urlShortenerRepository.getURLShortenedByKey(shortURLKey);
    LocalDateTime validUntil = longURL.getValidUntil();
    final URI response = new URI(longURL.getUrl());
    return new ExpandShortURLResponse(response, validUntil);
  }
}