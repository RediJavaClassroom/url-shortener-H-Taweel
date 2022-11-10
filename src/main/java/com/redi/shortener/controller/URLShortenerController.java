package com.redi.shortener.controller;

import com.redi.shortener.model.CreateShortURLRequest;
import com.redi.shortener.model.CreateShortURLResponse;
import com.redi.shortener.model.ExpandShortURLResponse;
import com.redi.shortener.services.URLShortenerService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLShortenerController {
  @Autowired URLShortenerService urlShortenerService;

  @PostMapping("/short-links")
  public CreateShortURLResponse shorten(@RequestBody final CreateShortURLRequest request, LocalDate validUntil)
      throws MalformedURLException {
    return urlShortenerService.create(request, validUntil);
  }

  @GetMapping("/{key}")
  public ExpandShortURLResponse expand(@PathVariable final String key) throws URISyntaxException {
    return urlShortenerService.expand(key);
  }
}