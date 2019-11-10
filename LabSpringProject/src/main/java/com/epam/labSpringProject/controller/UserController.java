package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.UserService;
import com.epam.security_module.SecurityService;
import com.epam.security_module.UnauthorizedAccessAttemptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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

    public void isAdminAuthority(User user) {
        userService.isAdminAuthority(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return user;
    }


}
