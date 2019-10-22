package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private DataBase dataBase = new DataBase();
    private Long idCounter;

    @Override
    public Task addTask(User user, String description) {
        return (Task) dataBase.save(new Task(idAutoIncrement(), description, false, user.getId()));
    }

    @Override
    public Task getTaskById(Long taskId) {
        return (Task) dataBase.findOne(taskId);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        dataBase.delete(dataBase.getTaskRepository().stream().allMatch(task -> (task.getId() == taskId)));
    }

    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return  dataBase.getTaskRepository().stream()
                .filter(task -> (task.getUserId() == userId))
                .collect(Collectors.toList());
    }

    @Override
    public Task updateTask(Task task) {
        deleteTaskById(task.getId());
        return (Task) dataBase.save(task);
    }

    private Long idAutoIncrement(){
        return ++idCounter;
    }

}
