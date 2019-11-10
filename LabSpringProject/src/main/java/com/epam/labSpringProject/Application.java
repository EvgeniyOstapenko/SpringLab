package com.epam.labSpringProject;

import com.epam.labSpringProject.config.ApplicationConfig;
import com.epam.labSpringProject.controller.TaskController;
import com.epam.labSpringProject.controller.UserController;
import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.utility.TaskPriority;
import com.epam.labSpringProject.utility.UserRole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static String subscription = "Not subscribed user";

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();

        TaskController taskController = context.getBean(TaskController.class);
        UserController userController = context.getBean(UserController.class);

        User user1 = User.builder()
                .name("Evgeniy")
                .surname("Ostapenko")
                .email("evgeniy@ru")
                .number("89111750068")
                .password("password")
                .userRole(UserRole.USER)
                .subscription(subscription)
                .build();

        userController.singUp(user1);
        userController.singUp(user1);
        System.out.println(userController.findById(1l));
        System.out.println(userController.findById(2l));
        User user2 = userController.findById(2l);
//        System.out.println(user1.getId());

//        userController.getSubscription(user1);

        Task task1 = taskController.createNewTask(new Task(0L, "firstTask", false, TaskPriority.MEDIUM, user2.getId()));
//        taskController.createNewTask(new Task(0L, "secondTask", false, TaskPriority.MEDIUM, user1.getId()));
//        System.out.println(task1.getUserId());
        System.out.println(taskController.getAllTasks());
        System.out.println(taskController.getAllUserTasks(user2));

        System.out.println("----------");
        System.out.println(userController.findById(1L));
        System.out.println(userController.findById(1L));


//        taskController.createNewTask(new Task(0L, "secondTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "thirdTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "forthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "fifthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "sixthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "seventhTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "eighthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "ninthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "tenthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "eleventhTask", false, TaskPriority.MEDIUM, user1.getId()));


//        user1.setUserRole(UserRole.ADMIN);
//        userController.isAdminAuthority(user1);


    }
}
