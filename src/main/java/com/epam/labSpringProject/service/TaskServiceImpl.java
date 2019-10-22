package com.epam.labSpringProject.service;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(User user, String description) {
        return taskRepository.addTask(user, description);
    }

    @Override
    public void deleteTask(Task task) throws RuntimeException{
        taskRepository.deleteTaskById(task.getId());
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
