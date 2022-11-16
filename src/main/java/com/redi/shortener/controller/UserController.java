package com.redi.shortener.controller;

import com.redi.shortener.model.User;
import com.redi.shortener.model.UserRegistration;
import com.redi.shortener.services.UserService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired UserService userService;

  @PostMapping("/users")
  public User post(@RequestBody final UserRegistration registration) {
    return userService.create(registration);
  }

  @GetMapping("/users/{id}")
  public User get(@PathVariable final UUID id) {
    return userService.get(id);
  }
}