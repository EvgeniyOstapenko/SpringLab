package com.epam.labSpringProject.service;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;

import java.util.List;

public interface TaskService {

    //    Создать задачу
    Task createTask(User user, String description);

    //    Удалить задачу
    void deleteTask(Task task);

    //    Найти все свои задачи
    List<Task> findAllUserTasks(User user);

    //    Пометить задачу как выполненная
    //    Пометить задачу как невыполненная
    Task setState(Task task, boolean state);

}
