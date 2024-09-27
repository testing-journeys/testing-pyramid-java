package org.chicu.controller;

import org.chicu.model.User;
import org.chicu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/v1/users")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }
}
