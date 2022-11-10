package com.redi.shortener.services;

import com.redi.shortener.model.User;
import com.redi.shortener.model.UserRegistration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

class UserServiceTest {
    final UserService service = new UserService();

    @Test
    void shouldCreateUserWithRegistrationName() {
        final UserRegistration registration = new UserRegistration("Joe", "joe@example.com");
        final User user = service.create(registration);

        assertThat(user.name(), equalTo(registration.name()));
    }

    @Test
    void shouldCreateRandomIds() {
        final UserRegistration registration1 = new UserRegistration("Joe", "joe@example.com");
        final UserRegistration registration2 = new UserRegistration("Paul", "paul@example.com");
        final User user1 = service.create(registration1);
        final User user2 = service.create(registration2);
        assertThat(user1.id(), not(equalTo(user2.id())));
    }
}