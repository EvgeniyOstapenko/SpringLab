package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private DataBase dataBase;
    private Long idCounter = 0l;

    @Autowired
    public TaskRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Task saveTask(Task task) {
        dataBase.getTaskRepository().add(idAutoIncrement(task));
        return task;
    }

    @Override
    public Task getTaskById(Long taskId) {
        return  dataBase.getTaskRepository().stream()
                .filter(task -> (taskId.equals(task.getId())))
                .findFirst().get();
    }

    @Override
    public void deleteTaskById(Long taskId) {
        dataBase.getTaskRepository()
                .remove(dataBase.getTaskRepository()
                                .stream()
                                .filter(task -> task.getId().equals(taskId))
                                .findAny().get());
    }

    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return  dataBase.getTaskRepository()
                        .stream()
                        .filter(task -> task.getId().equals(userId))
                        .collect(Collectors.toList());
    }

    @Override
    public Task updateTask(Task updatedTask) {
        dataBase.getTaskRepository().removeIf(task -> task.getId().equals(updatedTask.getId()));
        dataBase.getTaskRepository().add(updatedTask);
        return updatedTask;
    }

    private Task idAutoIncrement(Object o){
        Task task = (Task) o;
        task.setId(++idCounter);
        return task;
    }
}
