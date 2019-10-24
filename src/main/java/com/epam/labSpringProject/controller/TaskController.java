package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public Task createNewTask(User user, String description){
        return taskService.createTask(user, description);
    }

    public void deleteTask(Task task) {
        taskService.deleteTask(task);
    }

    public List<Task> findAllUserTask(User user) {
        return taskService.findAllUserTasks(user);
    }

    public void markTaskComplete(Task task) {
        taskService.setState(task, true);
    }

    public void markTaskNotComplete(Task task) {
        taskService.setState(task, false);
    }

}
