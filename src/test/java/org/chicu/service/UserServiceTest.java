package org.chicu.service;

import org.chicu.model.User;
import org.chicu.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Unit Test (Service Components - Mocking dependencies)
@SpringBootTest(classes = UserService.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void getUsers() {
        // data
        Collection<User> expectedUsers = Arrays.asList(
                new User("user-1", "user 1 details"),
                new User("user-1", "user 1 details"));
        // dependencies setup
        when(userRepository.getAllUsers()).thenReturn(expectedUsers);
        // act
        Collection<User> actualUsers = userService.getUsers();
        // assertions
        assertEquals(expectedUsers, actualUsers, "Users incorrectly retrieved");
    }
}