package org.chicu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String username;
    private String details;

    public User(String username) {
        this.username = username;
    }
}
