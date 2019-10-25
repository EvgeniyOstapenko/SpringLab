package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User singUp(User user) {
        return userService.toRegister(user);
    }

    public User singIn(String email, String password) {
        return  userService.toEnter(email, password);
    }

    public void getSubscription(User user){
        userService.subscribe(user);
    }
}
