package com.redi.shortener.services;

import com.redi.shortener.model.TimeStamping;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TimeStampService {
    public TimeStamping createTimeStamp() {
        return new TimeStamping(Instant.now());
    }
}