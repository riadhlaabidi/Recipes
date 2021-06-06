package com.example.recipes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository users;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    public void add(User user) {
        if (users.existsById(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        users.save(user);
    }
}
