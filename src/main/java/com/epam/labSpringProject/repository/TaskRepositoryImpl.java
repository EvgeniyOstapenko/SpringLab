package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private DataBase dataBase;
    private Long idCounter = 0L;

    @Autowired
    public TaskRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Task saveTask(Task task) {
        dataBase.getTasksTable().add(idAutoIncrement(task));
        System.out.println("TasksTable size" + dataBase.getTasksTable().size());
        return task;
    }

    @Override
    public Task getTaskById(Long taskId) {
        return  dataBase.getTasksTable().stream()
                .filter(task -> (taskId.equals(task.getId())))
                .findFirst().orElse(null);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        dataBase.getTasksTable()
                .remove(dataBase.getTasksTable()
                                .stream()
                                .filter(task -> task.getId().equals(taskId))
                                .findAny().orElse(null));
    }

    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return  dataBase.getTasksTable()
                        .stream()
                        .filter(task -> task.getUserId().equals(userId)) // return only one element!
                        .collect(Collectors.toList());
    }

    @Override
    public Task updateTask(Task updatedTask) {
        dataBase.getTasksTable().removeIf(task -> task.getId().equals(updatedTask.getId()));
        dataBase.getTasksTable().add(updatedTask);
        return updatedTask;
    }

    private Task idAutoIncrement(Object o){
        Task task = (Task) o;
        task.setId(++idCounter);
        return task;
    }
}
