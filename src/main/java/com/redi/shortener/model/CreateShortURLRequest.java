package com.redi.shortener.model;

import java.net.URL;

public record CreateShortURLRequest(URL url, int validUntil) {}
