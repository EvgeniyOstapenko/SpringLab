package com.epam.labSpringProject.service;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    void deleteTask(Task task);

    List<Task> getAllUserTasks(User user);

    List<Task> getAllTasks();

    Task setState(Task task, boolean state);


}
