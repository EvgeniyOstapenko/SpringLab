package com.epam.labSpringProject.service;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;

import java.util.List;

public interface TaskService {

    Task createTask(User user, String description);

    void deleteTask(Task task);

    List<Task> findAllUserTasks(User user);

    Task setState(Task task, boolean state);

}
