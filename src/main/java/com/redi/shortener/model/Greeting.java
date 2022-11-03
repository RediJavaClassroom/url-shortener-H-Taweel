package com.redi.shortener.model;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

//public record Greeting(UUID id, String name) {}
public class Greeting {
    private final String id;
    private final String name;
    public Greeting(UUID id, String name){
        this.id = RandomStringUtils.randomAlphanumeric(7);
        this.name = Arrays.stream(name.split("\\s+"))
                .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
