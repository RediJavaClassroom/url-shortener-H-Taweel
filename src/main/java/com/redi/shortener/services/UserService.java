package com.redi.shortener.services;

import com.redi.shortener.model.User;
import com.redi.shortener.model.UserRegistration;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final Map<UUID, User> usersDB = new ConcurrentHashMap<>();

  public User create(final UserRegistration registration) {
    final UUID id = UUID.randomUUID();
    if (usersDB.values().stream()
        .anyMatch(user -> user.email().equals(registration.email().toLowerCase()))) {
      throw new RuntimeException("User already exists: " + id);
    }
    final User user =
        new User(
            id,
            UserService.capitalizeWord(registration.name()),
            registration.email().toLowerCase());
    usersDB.put(id, user);
    return user;
  }

  public User get(final UUID userId) {
    return usersDB.get(userId);
  }

  public static String capitalizeWord(String str) {
    return Arrays.stream(str.split("\\s+"))
        .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase())
        .collect(Collectors.joining(" "));
  }
}