package com.epam.labSpringProject;

import com.epam.labSpringProject.config.ApplicationConfig;
import com.epam.labSpringProject.controller.TaskController;
import com.epam.labSpringProject.controller.UserController;
import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.utility.TaskPriority;
import com.epam.labSpringProject.utility.UserRole;
import com.epam.security_module.UnauthorizedAccessAttemptException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.epam.security_module.UserRoleValidation.isValidUserRole;

public class Application {

    private static String   subscription = "Not subscribed user";

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();

        TaskController taskController = context.getBean(TaskController.class);
        UserController userController = context.getBean(UserController.class);

//        User user1 = new User(0L, "Evgeniy", "Ostapenko",
//                              "evgeniy@ru", "89111750068",
//                              "password", "");

//        User user1 = User.builder()
//                .subscription(subscription)
//                .build();

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
//        userController.getSubscription(user1);

        taskController.createNewTask(new Task(0L, "firstTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "secondTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "thirdTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "forthTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "fifthTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "sixthTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "seventhTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "eighthTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "ninthTask", false, TaskPriority.MEDIUM, user1.getId()));
        taskController.createNewTask(new Task(0L, "tenthTask", false, TaskPriority.MEDIUM, user1.getId()));
//        taskController.createNewTask(new Task(0L, "eleventhTask", false, TaskPriority.MEDIUM, user1.getId()));


        try {
            isValidUserRole(user1.getUserRole().toString());
        } catch (UnauthorizedAccessAttemptException e) {
            e.printStackTrace();
        }


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

//        User user2 = new User(0L,
//                                "Evgeniy",
//                                "Ostapenko",
//                                "evgeniy@ru",
//                                "89111750068",
//                                "password",
//                                "");
//
    }
}
