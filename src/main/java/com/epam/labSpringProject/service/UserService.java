package com.epam.labSpringProject.service;


import com.epam.labSpringProject.model.User;

public interface UserService {

    User toRegister(String name, String surname, String email, String number, String password);

    User toEnter(String email, String password);

    void subscribe(User user);
}
