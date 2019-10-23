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
        Task task = taskService.createTask(user, description);
        System.out.println("A new task has been created : \n" + task.getDescription());
        return task;
    }

    public void deleteTask(Task task) {
        try{
            taskService.deleteTask(task);
        }catch (RuntimeException e){
            System.out.println(e.getMessage()); //"No task with such ID found!"
        }
        System.out.println("Task : " + task + " has been successfully deleted!");
    }

    public List<Task> findAllUserTask(User user) {
        List<Task> tasks = taskService.findAllUserTasks(user);
        for (Task task : tasks) {
             System.out.println(task);
        }
        return tasks;
    }

    public void markTaskComplete(Task task) {
        taskService.setState(task, true);
    }

    public void markTaskNotComplete(Task task) {
        taskService.setState(task, false);
    }

}
