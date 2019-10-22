package com.epam.labSpringProject.controller;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.TaskService;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    private final TaskService taskService;

    public UserController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void createNewTask(User user, String description){
        Task newTask = taskService.createTask(user, description);
        System.out.println("A new task has been created : \n" + newTask.getDescription());
    }

    public void deleteTask(Task task) {
        try{
            taskService.deleteTask(task);
        }catch (RuntimeException e){
            System.out.println(e.getMessage()); //"No task with such ID found!"
        }
        System.out.println("Task : " + task + " has been successfully deleted!");
    }

    public void findAllUserTask(User user) {
        for (Task task : taskService.findAllUserTasks(user)) {
             System.out.println(task);
        }
    }

    public void markTaskComplete(Task task) {
        taskService.setState(task, true);
    }

    public void markTaskNotComplete(Task task) {
        taskService.setState(task, false);
    }

}
