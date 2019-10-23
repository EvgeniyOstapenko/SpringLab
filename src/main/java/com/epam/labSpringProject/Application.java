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

        User user1 = new User(0l, "q", "w", "g", "g");
        User user2 = new User(0l, "q", "w", "g", "g");
        User user3 = new User(0l, "q", "w", "g", "g");

        Task task = taskController.createNewTask(user1, "firstTask");
        taskController.createNewTask(user1, "secondTask");
        taskController.findAllUserTask(user1);

        taskController.markTaskComplete(task);

        taskController.findAllUserTask(user1);

    }
}
