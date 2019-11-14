package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTaskRepositoryImpl implements TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    private String INSERT = "insert into TASKS (description, isDone, taskPriority, userId) values(?,?,?,?)";
    private String GET_BY_ID = "select id, name, surname, email, number, password,"
            + " subscription, userRole from TASKS where email=?";
    private String GET_BY_USER_ID = "select id, description, isDone, taskPriority, userId from TASKS where userId=?";
    private String GET_ALL = "select * from TASKS";


    @Autowired
    public JdbcTaskRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Task save(Task task) {
        jdbcTemplate.update(INSERT, task.getDescription(), task.isDone(), task.getTaskPriority().name(), task.getUserId());
        return task;
    }

    @Override
    public Task getById(Long taskId) {
        return null;
    }

    @Override
    public void deleteById(Long taskId) {

    }

    @Override
    public List<Task> getByUserId(Long userId) {
        return jdbcTemplate.query(GET_BY_USER_ID, new TaskRowMapper(), userId);
    }

    @Override
    public List<Task> getAll() {
        return jdbcTemplate.query(GET_ALL, new TaskRowMapper());
    }


    @Override
    public Task update(Task task) {
        return null;
    }
}