package com.redi.shortener.services;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import java.net.MalformedURLException;
import java.net.URI;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {
  Map<UUID, URI> urlsDB = new HashMap<>();

  public CreateShortURLResponse create(final CreateShortURLRequest request)
      throws MalformedURLException {
    String domainName = "http://localhost:8080/";

    if (urlsDB.containsKey(request.url())) {
      UUID w = urlsDB.get(request.url());
      URL shortURL = new URL(domainName + w);
      return new CreateShortURLResponse(shortURL);
    }
    UUID identifier = UUID.randomUUID();
    URI shortURL = URI.create(domainName + identifier);
    urlsDB.put(identifier, request.url());
    return new CreateShortURLResponse(shortURL);
  }
}
