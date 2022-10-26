package com.redi.shortener.controller;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.services.URLShortenerService;
import java.net.MalformedURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLShortenerController {
  @Autowired URLShortenerService urlShortenerService;

  @PostMapping("/shortener")
  public CreateShortURLResponse shortener(@RequestBody final CreateShortURLRequest request)
      throws MalformedURLException {
    return urlShortenerService.create(request);
  }
}
