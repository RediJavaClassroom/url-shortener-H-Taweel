package com.redi.shortener.services;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.model.ExpandShortURLResponse;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService {
  Map<String, URI> urlsDB = new HashMap<>();

  public CreateShortURLResponse create(final CreateShortURLRequest request)
      throws MalformedURLException {
    String domainName = "http://localhost:8080/";

    //    if (urlsDB.containsValue(request.url())) {
    //      UUID w = urlsDB.get(request.url());
    //      URL shortURL = new URL(domainName + w);
    //      return new CreateShortURLResponse(shortURL);
    //    }
    String identifier = RandomStringUtils.randomAlphanumeric(7);
    URI shortURL = URI.create(domainName + identifier);
    urlsDB.put(identifier, request.url());
    return new CreateShortURLResponse(shortURL);
  }

      public ExpandShortURLResponse expand(final ExpandShortURLRequest request) {

//      if (urlsDB.containsKey(request.shortURLKey())){
//          urlsDB.get(request.shortURLKey());
//      }
      return new ExpandShortURLResponse(urlsDB.get(request.shortURLKey()));
    }

}
