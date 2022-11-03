package com.redi.shortener.services;

import com.redi.shortener.model.TimeStamping;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

class TimeStampServiceTest {

    @Test
    void createTimeStamp() {
        TimeStampService service = new TimeStampService();
        final TimeStamping timeStamping = service.createTimeStamp();

        assertThat(timeStamping.timeStamp(), lessThanOrEqualTo(Instant.now())); // timestmp > now
    }
}