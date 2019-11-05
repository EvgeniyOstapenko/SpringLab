package com.epam.labSpringProject.service;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(JdbcTaskRepositoryImpl taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        Task createdTask = taskRepository.save(task);
        return createdTask;
    }

    @Override
    public void deleteTask(Task task) throws RuntimeException{
        try {
            taskRepository.deleteById(task.getId());
        }catch (RuntimeException e){
            System.out.println(e.getMessage()); //"No task with such ID found!"
        }
        System.out.println("Task : " + task + " has been successfully deleted!");
    }

    @Override
    public List<Task> getAllUserTasks(User user) {
        return taskRepository.getByUserId(user.getId());
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAll();
    }

    @Override
    public Task setState(Task task, boolean state) {
        Task currentTask = taskRepository.getById(task.getId());
        currentTask.setDone(state);
        return taskRepository.update(currentTask);
    }
}
