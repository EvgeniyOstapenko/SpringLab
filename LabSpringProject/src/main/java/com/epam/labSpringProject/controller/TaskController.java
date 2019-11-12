package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createNewTask(Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(Task task) {
        taskService.deleteTask(task);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllUserTasks(User user) {
        return taskService.getAllUserTasks(user);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{taskId}/complete")
    public void markTaskComplete(Task task) {
        taskService.setState(task, true);
    }

    @PutMapping("/{taskId}/not-complete")
    public void markTaskNotComplete(Task task) {
        taskService.setState(task, false);
    }

}
