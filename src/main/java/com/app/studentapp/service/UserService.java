package com.app.studentapp.service;

import com.app.studentapp.model.User;
import com.app.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User register(User user) {
        return repository.save(user);
    }


    public String login(String email, String password) {

        User user = repository.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        if (user.getPassword().equals(password)) {
            return "Login success";
        }

        return "Wrong password";
    }
}