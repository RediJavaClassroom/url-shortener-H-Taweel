package com.redi.shortener.controller;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.model.ExpandShortURLResponse;
import com.redi.shortener.services.URLShortenerService;
import java.net.MalformedURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLShortenerController {
  @Autowired URLShortenerService urlShortenerService;

  @PostMapping("/shortener/shorten")
  public CreateShortURLResponse shortener(@RequestBody final CreateShortURLRequest request)
      throws MalformedURLException {
    return urlShortenerService.create(request);
  }

  @GetMapping("/shortener/expand")
  public ExpandShortURLResponse expand(@RequestBody final ExpandShortURLRequest response){
    return urlShortenerService.expand(response);
  }

}
