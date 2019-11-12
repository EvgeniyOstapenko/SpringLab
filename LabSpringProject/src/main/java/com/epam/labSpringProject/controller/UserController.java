package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/singUp")
    @ResponseStatus(HttpStatus.CREATED)
    public User singUp(User user) {
        return userService.toRegister(user);
    }

    @GetMapping("/singIn")
    @ResponseStatus(HttpStatus.OK)
    public User singIn(User user) {
        return userService.toEnter(user);
    }


    @PutMapping("/getSubscription")
    @ResponseStatus(HttpStatus.OK)
    public User getSubscription(User user) {
        userService.subscribe(user);
        return user;
    }

    @GetMapping("/isAdmin")
    @ResponseStatus(HttpStatus.OK)
    public void isAdminAuthority(User user) {
        userService.isAdminAuthority(user);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllUserTasks(User user) {
        return userService.getAllUserTasks(user);
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return user.toString();
    }


}
