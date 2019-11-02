package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.UserService;
import com.epam.security_module.SecurityService;
import com.epam.security_module.UnauthorizedAccessAttemptException;
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

    public User singIn(User user) {
        return  userService.toEnter(user);
    }

    public void getSubscription(User user){
        userService.subscribe(user);
    }

    public void isAdminAuthority(SecurityService service, User user) {
        userService.isAdminAuthority(service, user);
    }
}
