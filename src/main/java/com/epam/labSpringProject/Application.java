package com.epam.labSpringProject;

import com.epam.labSpringProject.config.ApplicationConfig;
import com.epam.labSpringProject.controller.TaskController;
import com.epam.labSpringProject.controller.UserController;
import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();

        TaskController taskController = context.getBean(TaskController.class);
        UserController userController = context.getBean(UserController.class);

        User user1 = new User(0L, "Evgeniy", "Ostapenko",
                              "evgeniy@ru", "89111750068",
                              "password", "");

        userController.singUp(user1);
        userController.getSubscription(user1);

        taskController.createNewTask(new Task(0L, "firstTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "secondTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "thirdTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "forthTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "fifthTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "sixthTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "seventhTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "eighthTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "ninthTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "tenthTask", false, user1.getId()));
        taskController.createNewTask(new Task(0L, "eleventhTask", false, user1.getId()));


//
//        System.out.println(task1.getId());
//        System.out.println(task2.getId());
//        System.out.println(task3.getId());



//        taskController.createNewTask(user1, "secondTask");
//        taskController.findAllUserTask(user1);
//
//        taskController.markTaskComplete(task1);
//
//        taskController.findAllUserTask(user1);

        User user2 = new User(0L,
                                "Evgeniy",
                                "Ostapenko",
                                "evgeniy@ru",
                                "89111750068",
                                "password",
                                "");

    }
}
