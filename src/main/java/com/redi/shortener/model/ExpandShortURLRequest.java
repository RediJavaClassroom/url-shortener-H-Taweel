package com.redi.shortener.model;


import java.net.URI;

public record ExpandShortURLRequest(URI shortURLKey) {}
