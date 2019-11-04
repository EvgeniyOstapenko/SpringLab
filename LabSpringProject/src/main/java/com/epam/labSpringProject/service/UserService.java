package com.epam.labSpringProject.service;


import com.epam.labSpringProject.model.User;
import com.epam.security_module.SecurityService;
import com.epam.security_module.UnauthorizedAccessAttemptException;

public interface UserService {

    User toRegister(User user);

    User toEnter(User user);

    void subscribe(User user);

    User getById(Long userId);

    void isAdminAuthority(User user);
}
