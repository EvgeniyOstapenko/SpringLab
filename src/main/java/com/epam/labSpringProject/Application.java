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

        User user1 = userController.singUp( "Evgeniy",
                                            "Ostapenko",
                                            "evgeniy@ru",
                                            "89111750068",
                                            "password");

        Task task1 = taskController.createNewTask(user1, "firstTask");
        Task task2 = taskController.createNewTask(user1, "secondTask");
        Task task3 = taskController.createNewTask(user1, "thirdTask");
        Task task4 = taskController.createNewTask(user1, "forthTask");
        Task task5 = taskController.createNewTask(user1, "fifthTask");
        Task task6 = taskController.createNewTask(user1, "sixthTask");
        Task task7 = taskController.createNewTask(user1, "seventhTask");
        Task task8 = taskController.createNewTask(user1, "eighthTask");
        Task task9 = taskController.createNewTask(user1, "ninthTask");
        Task task10 = taskController.createNewTask(user1, "tenthTask");
        Task task11 = taskController.createNewTask(user1, "eleventhTask");

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

        User user3 = userController.singUp( "Evgeniy",
                                            "Ostapenko",
                                            "evgeniy@ru",
                                            "89111750068",
                                            "password");

    }
}
