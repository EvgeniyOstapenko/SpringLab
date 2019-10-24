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


        User user3 = userController.singUp( "Evgeniy",
                                            "Ostapenko",
                                            "evgeniy@ru",
                                            "89111750068",
                                            "password");


//        Task task1 = taskController.createNewTask(user1, "firstTask");
//        Task task2 = taskController.createNewTask(user1, "secondTask");
//        Task task3 = taskController.createNewTask(user1, "thirdTask");
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

    }
}
