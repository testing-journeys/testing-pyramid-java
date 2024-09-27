package org.chicu.service;

import org.chicu.model.User;
import org.chicu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Collection<User> getUsers() {
        return userRepository.getAllUsers();
    }
}
