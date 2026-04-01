package com.app.studentapp.controller;

import com.app.studentapp.model.User;
import com.app.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }


    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password) {

        return service.login(email, password);
    }
}