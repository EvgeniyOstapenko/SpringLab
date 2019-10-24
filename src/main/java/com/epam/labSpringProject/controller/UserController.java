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

    public User singUp(String name, String surname, String email, String number, String password) {
        return userService.toRegister(name, surname, email, number, password);
    }

    public User singIn(String email, String password) {
        User user = userService.toEnter(email, password);
        return user;
    }

    public void getSubscription(User user){
        userService.subscribe(user);
    }
}
