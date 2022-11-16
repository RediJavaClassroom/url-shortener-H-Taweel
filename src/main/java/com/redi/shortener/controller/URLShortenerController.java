package com.redi.shortener.controller;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.model.ExpandShortURLResponse;
import com.redi.shortener.services.URLShortenerService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLShortenerController {
  @Autowired URLShortenerService urlShortenerService;

  @PostMapping("/short-links")
  public CreateShortURLResponse shorten(@RequestBody final CreateShortURLRequest request)
      throws MalformedURLException {
    return urlShortenerService.create(request);
  }

  @GetMapping("/{key}")
  public ExpandShortURLResponse expand(@PathVariable final String key) throws URISyntaxException {
    return urlShortenerService.expand(key);
  }
//  @GetMapping("/{key}")
//  ResponseEntity<Void> expand() {
//    try {
//      return ResponseEntity.status(HttpStatus.FOUND)
//              .location(URI.create(String.valueOf(urlShortenerService.expand("key"))))
//              .build();
//    } catch (URISyntaxException e) {
//      throw new RuntimeException(e);
//    }
//  }
}