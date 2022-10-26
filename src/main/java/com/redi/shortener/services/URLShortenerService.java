package com.redi.shortener.services;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {
  Map<URL, UUID> urlsDB = new HashMap<>();

  public CreateShortURLResponse create(final CreateShortURLRequest request)
      throws MalformedURLException {
    String domainName = "http://localhost:8080/";

    if (urlsDB.containsKey(request.url())) {
      UUID w = urlsDB.get(request.url());
      URL shortURL = new URL(domainName + w);
      return new CreateShortURLResponse(shortURL);
    }
    UUID identifier = UUID.randomUUID();
    URL shortURL = new URL(domainName + identifier);
    urlsDB.put(request.url(), identifier);
    return new CreateShortURLResponse(shortURL);
  }
}
