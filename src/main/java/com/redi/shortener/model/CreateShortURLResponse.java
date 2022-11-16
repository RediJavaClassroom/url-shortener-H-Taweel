package com.redi.shortener.model;

import java.net.URI;
import java.time.LocalDate;

public record CreateShortURLResponse(URI shortURL, LocalDate validUntil) {}