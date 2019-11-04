package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private String INSERT = "insert into USERS (name, surname, email, number, password, subscription, userRole)"
            + " values(?,?,?,?,?,?,?)";
    private String FIND_BY_EMAIL = "select id, name, surname, email, number, password,"
            + " subscription, userRole from USERS where email=?";
    private String UPDATE_SUBSCRIPTION = "update USERS set subscription=? where email=?";


    @Autowired
    public JdbcUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update(INSERT, user.getName(), user.getSurname(), user.getEmail(),
                user.getNumber(), user.getPassword(), user.getSubscription(), user.getUserRole().name());
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(FIND_BY_EMAIL, new UserRowMapper(), email);
    }

    @Override
    public User getById(Long id) {
        return null;
    }

}
