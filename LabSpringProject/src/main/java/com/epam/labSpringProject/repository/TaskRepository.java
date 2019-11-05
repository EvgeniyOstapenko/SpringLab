package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;

import java.util.List;

public interface TaskRepository {

    Task save(Task task);

    Task getById(Long taskId);

    void deleteById(Long taskId);

    List<Task> getByUserId(Long userId);

    Task update(Task task);

}
