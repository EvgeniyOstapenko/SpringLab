package com.epam.labSpringProject.service;


import com.epam.labSpringProject.model.User;

public interface UserService {

    User toRegister(User user);

    User toEnter(String email, String password);

    void subscribe(User user);
}
