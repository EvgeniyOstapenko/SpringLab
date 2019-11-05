package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private MyDataBase myDataBase;
    private Long idCounter = 0L;

    @Autowired
    public TaskRepositoryImpl(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }

    @Override
    public Task save(Task task) {
        myDataBase.getTasksTable().add(idAutoIncrement(task));
        return task;
    }

    //TODO throws TaskNotExistException
    @Override
    public Task getById(Long taskId) {
        return  myDataBase.getTasksTable().stream()
                .filter(task -> (taskId.equals(task.getId())))
                .findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long taskId) {
        myDataBase.getTasksTable()
                .remove(myDataBase.getTasksTable()
                                .stream()
                                .filter(task -> task.getId().equals(taskId))
                                .findAny().orElse(null));
    }

    @Override
    public List<Task> getByUserId(Long userId) {
        return  myDataBase.getTasksTable()
                        .stream()
                        .filter(task -> task.getUserId().equals(userId)) // return only one element!
                        .collect(Collectors.toList());
    }

    @Override
    public Task update(Task updatedTask) {
        myDataBase.getTasksTable().removeIf(task -> task.getId().equals(updatedTask.getId()));
        myDataBase.getTasksTable().add(updatedTask);
        return updatedTask;
    }

    private Task idAutoIncrement(Object o){
        Task task = (Task) o;
        task.setId(++idCounter);
        return task;
    }
}
