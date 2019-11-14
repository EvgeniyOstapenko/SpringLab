package com.epam.labSpringProject.service;


import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;

import java.util.List;

public interface UserService {

    User toRegister(User user);

    User toEnter(User user);

    void subscribe(User user);

    User getById(Long userId);

    List<Task> getAllUserTasks(User user);

    void isAdminAuthority(User user);
}
