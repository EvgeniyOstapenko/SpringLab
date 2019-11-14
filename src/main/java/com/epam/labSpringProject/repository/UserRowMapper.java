package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.utility.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        String number = resultSet.getString("number");
        String password = resultSet.getString("password");
        String subscription = resultSet.getString("subscription");
        UserRole userRole = UserRole.valueOf(resultSet.getString("userRole"));

        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .surname(surname)
                .number(number)
                .password(password)
                .subscription(subscription)
                .userRole(userRole)
                .build();
    }
}
