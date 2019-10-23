package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataBase implements CrudRepository {

    private List<Task>  taskRepository = new ArrayList<>();
    private Long idCounter;


    @Override
    public synchronized Object save(Object entity) {
        Task task = (Task) entity;
        task.setId(idAutoIncrement());
        return taskRepository.add(task);
    }

    @Override
    public synchronized Iterable save(Iterable entities) {
        return null;
    }


    @Override
    public synchronized Object findOne(Serializable taskId) {
        return  taskRepository.stream()
                .filter(task -> (taskId.equals(task.getId())))
                .findFirst().get();
    }

    @Override
    public synchronized boolean exists(Serializable serializable) {
        return false;
    }

    @Override
    public synchronized List<Task> findAll() {
        return taskRepository;
    }

    @Override
    public synchronized long count() {
        return 0;
    }

    @Override
    public synchronized void delete(Serializable serializable) {

    }

    @Override
    public synchronized void delete(Object entity) {
        taskRepository.remove(entity);
    }

    @Override
    public synchronized void delete(Iterable entities) {

    }

    @Override
    public synchronized void deleteAll() {

    }

    private synchronized Long idAutoIncrement(){
        return ++idCounter;
    }

}
