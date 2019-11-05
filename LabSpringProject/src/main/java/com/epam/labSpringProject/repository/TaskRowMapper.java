package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.utility.TaskPriority;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String description = resultSet.getString("description");
        boolean isDone = resultSet.getBoolean("isDone");

        System.out.println("---------");
        System.out.println(resultSet.getString("taskPriority"));


        TaskPriority taskPriority = TaskPriority.valueOf(resultSet.getString("taskPriority"));
        Long userId = resultSet.getLong("userId");


        return Task.builder()
                .id(id)
                .description(description)
                .isDone(isDone)
                .taskPriority(taskPriority)
                .userId(userId)
                .build();
    }
}
