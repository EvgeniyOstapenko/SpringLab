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

    public Task createNewTask(Task task){
        return taskService.createTask(task);
    }

    public void deleteTask(Task task) {
        taskService.deleteTask(task);
    }

    public List<Task> getAllUserTasks(User user) {
        return taskService.getAllUserTasks(user);
    }

    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    public void markTaskComplete(Task task) {
        taskService.setState(task, true);
    }

    public void markTaskNotComplete(Task task) {
        taskService.setState(task, false);
    }

}
