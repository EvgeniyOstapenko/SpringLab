package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.*;
import com.epam.labSpringProject.utility.*;
import org.springframework.jdbc.core.*;

import java.sql.*;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String description = rs.getString("description");
        boolean isDone = rs.getBoolean("isDone");
        TaskPriority priority = TaskPriority.valueOf(rs.getString("priority"));
        Long userId = rs.getLong("userId");


        return Task.builder()
                .id(id)
                .description(description)
                .isDone(isDone)
                .priority(priority)
                .userId(userId)
                .build();
    }
}
