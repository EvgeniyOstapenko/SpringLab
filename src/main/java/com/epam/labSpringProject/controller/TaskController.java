package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/hello")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("/task")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createNewTask(Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/task")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(Task task) {
        taskService.deleteTask(task);
    }

    @GetMapping("/task")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{taskId}/complete")
    public Task markTaskComplete(Task task) {
        taskService.setState(task, true);
        return task;
    }

    @PutMapping("/{taskId}/not-complete")
    public Task markTaskNotComplete(Task task) {
        taskService.setState(task, false);
        return task;
    }

}
