package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataBase implements CrudRepository {

    private List<Task>  taskRepository = new ArrayList<>();
    private Long idCounter = 0l;


    @Override
    public Object save(Object entity) {
        Task task = idAutoIncrement(entity);
        taskRepository.add(task);
        return task;
    }


    public Object findOne(Serializable taskId) {
        return  taskRepository.stream()
                .filter(task -> (taskId.equals(task.getId())))
                .findFirst().get();
    }

    @Override
    public Iterable saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository;
    }

    @Override
    public Iterable findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object entity) {
        taskRepository.remove(entity);
    }

    @Override
    public void deleteAll(Iterable entities) {

    }


    @Override
    public void deleteAll() {

    }

    private Task idAutoIncrement(Object o){
        Task task = (Task) o;
        task.setId(++idCounter);
        return task;
    }

}
