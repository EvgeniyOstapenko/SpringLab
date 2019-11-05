package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.*;
import com.epam.labSpringProject.utility.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class JdbcTaskRepositoryImpl implements TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    private String INSERT = "insert into TASKS (description, isDone, priority, userId) values(?,?,?,?)";
    private String GET_BY_ID = "select id, name, surname, email, number, password,"
            + " subscription, userRole from TASKS where email=?";
    private String GET_BY_USER_ID = "select id, description, isDone, priority, userId from TASKS where id=?";
    private String GET_ALL = "update TASKS set subscription=? where email=?";

    private Long id;
    private String description;
    private boolean isDone;
    private TaskPriority priority;
    private Long userId;

    @Autowired
    public JdbcTaskRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Task save(Task task) {
        jdbcTemplate.update(INSERT, task.getDescription(), task.isDone(), task.getPriority(), task.getId());
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
        jdbcTemplate.query(GET_BY_USER_ID, new TaskRowMapper(), userId);
        return null;
    }

    @Override
    public Task update(Task task) {
        return null;
    }
}
