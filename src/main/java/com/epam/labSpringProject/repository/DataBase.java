package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataBase implements CrudRepository {

    private List<Task> taskRepository = new ArrayList<>();


    @Override
    public Object save(Object entity) {
        return taskRepository.add((Task) entity);
    }

    @Override
    public Iterable save(Iterable entities) {
        return null;
    }

    @Override
    public Object findOne(Serializable taskId) {
        return  taskRepository.stream()
                .filter(task -> (taskId.equals(task.getId())))
                .findFirst().get();
    }

    @Override
    public boolean exists(Serializable serializable) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Serializable serializable) {
        taskRepository.remove(serializable);
    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void delete(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }

}
