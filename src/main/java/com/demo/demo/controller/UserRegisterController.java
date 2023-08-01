package com.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.domain.Users;
import com.demo.demo.service.UserService;

@RestController
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Users registerUser(@RequestBody Users users) {
        userService.save(users);
        userService.sendEmail(users.getEmail());
        return users;
    }
}
