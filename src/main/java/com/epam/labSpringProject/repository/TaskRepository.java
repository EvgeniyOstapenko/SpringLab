package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;

import java.util.List;

public interface TaskRepository {

    Task addTask(Task task);

    Task getTaskById(Long taskId);

    void deleteTaskById(Long taskId);

    List<Task> findTasksByUserId(Long userId);

    Task updateTask(Task task);

}
