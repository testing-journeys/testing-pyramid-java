package org.chicu.repository;

import org.chicu.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;

@Repository
public class UserRepository {

    public Collection<User> getAllUsers() {
        return Arrays.asList(
                new User("user-1", "user-1 details"),
                new User("user-2", "user-2 details"));
    }
}
