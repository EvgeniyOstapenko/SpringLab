package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private DataBase dataBase;

    @Override
    public Task addTask(Task task) {
        return (Task) dataBase.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return (Task) dataBase.findOne(taskId);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        dataBase.delete(dataBase.findAll().stream().allMatch(task -> (task.getId().equals(taskId))));
    }

    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return  dataBase.findAll().stream()
                .filter(task -> (task.getId().equals(userId)))
                .collect(Collectors.toList());

    }

    @Override
    public Task updateTask(Task task) {
        deleteTaskById(task.getId());
        return (Task) dataBase.save(task);
    }
}
