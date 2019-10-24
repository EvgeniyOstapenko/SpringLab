package com.epam.labSpringProject.aspect;

import com.epam.labSpringProject.exception.UnsubscribedUserException;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.service.TaskService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SubscriptionsVerification{
    private TaskService taskService;
    private static final String IS_SUBSCRIBED = "5ebe2294ecd0e0f08eab7690d2a6ee69";
    private static final int MAX_TASKS = 10;

    @Autowired
    public SubscriptionsVerification(TaskService taskService) {
        this.taskService = taskService;
    }

    @Pointcut("execution(public * com.epam.labSpringProject.service.TaskServiceImpl.createTask(user, description))" +
                                          "&& args(user, description)")

    public void taskCreation(User user, String description){}

    @Before("taskCreation(user, description)")
    public void beforeTaskCreation(User user, String description){
        if(user.getSubscription().equals(IS_SUBSCRIBED))
            return;
        if(taskService.findAllUserTasks(user).size() > 10) {
            throw new UnsubscribedUserException("Unsubscribed usage is limited to ten tasks!");
        }
    }
}
