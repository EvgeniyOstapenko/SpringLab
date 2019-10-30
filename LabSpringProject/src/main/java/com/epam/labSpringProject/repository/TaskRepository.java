package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;

import java.util.List;

public interface TaskRepository {

    Task saveTask(Task task);

    Task getTaskById(Long taskId);

    void deleteTaskById(Long taskId);

    List<Task> findTasksByUserId(Long userId);

    Task updateTask(Task task);

}
