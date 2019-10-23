package com.epam.labSpringProject;

import com.epam.labSpringProject.config.ApplicationConfig;
import com.epam.labSpringProject.controller.TaskController;
import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();

        TaskController taskController = context.getBean(TaskController.class);

        User user = new User();
//        Task task = taskController.createNewTask(user, "firstTask");
//        taskController.createNewTask(user, "secondTask");
//        taskController.findAllUserTask(user);
//
//        taskController.markTaskComplete(task);
//
//        taskController.findAllUserTask(user);

    }
}
