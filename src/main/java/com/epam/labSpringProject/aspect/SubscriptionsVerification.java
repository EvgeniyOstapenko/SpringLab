package com.epam.labSpringProject.aspect;

import com.epam.labSpringProject.exception.UnsubscribedUserException;
import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.TaskService;
import com.epam.labSpringProject.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SubscriptionsVerification{

    private TaskService taskService;
    private final UserService userService;
    private static final String IS_SUBSCRIBED = "5ebe2294ecd0e0f08eab7690d2a6ee69";
    private static final int MAX_TASKS = 10;

    @Autowired
    public SubscriptionsVerification(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @Pointcut("execution(public * com.epam.labSpringProject.service.TaskServiceImpl.createTask(com.epam.labSpringProject.model.Task))" +
                                                                       " && args(task)")
    public void taskCreation(Task task){}

    @Before("taskCreation(task)")
    public void beforeTaskCreation(Task task){
        User user = userService.getById(task.getUserId());
        if(user.getSubscription().equals(IS_SUBSCRIBED)) {
           return;
        }
        if(userService.getAllUserTasks(user).size() >= MAX_TASKS) {
            throw new UnsubscribedUserException("Unsubscribed usage is limited to ten tasks!");
        }
    }
}
