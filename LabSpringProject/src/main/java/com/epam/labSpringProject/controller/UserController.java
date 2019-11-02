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

    public User singIn(User user) {
        return  userService.toEnter(user);
    }

    public void getSubscription(User user){
        userService.subscribe(user);
    }

//    public void adminCheck(Secure_module service, User user) {
//        if(service.isAdmin(user.getUserRole().name())) {
//            System.out.println("Welcome Admin!");
//        } else {
//            throw  new UserRoleException("Go AWAY!");
//        }
//
//    }
}
