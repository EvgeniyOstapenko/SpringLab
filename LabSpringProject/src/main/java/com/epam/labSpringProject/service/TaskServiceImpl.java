package com.epam.labSpringProject.service;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final Long ID = 1L;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        Task createdTask = taskRepository.saveTask(task);

        //TODO add checking task
        System.out.println("A new task has been created: " + createdTask);
        return createdTask;
    }

    @Override
    public void deleteTask(Task task) throws RuntimeException{
        try {
            taskRepository.deleteTaskById(task.getId());
        }catch (RuntimeException e){
            System.out.println(e.getMessage()); //"No task with such ID found!"
        }
        System.out.println("Task : " + task + " has been successfully deleted!");
    }

    @Override
    public List<Task> findAllUserTasks(User user) {
        return taskRepository.findTasksByUserId(user.getId());
    }

    @Override
    public Task setState(Task task, boolean state) {
        Task currentTask = taskRepository.getTaskById(task.getId());
        currentTask.setDone(state);
        return taskRepository.updateTask(currentTask);
    }
}