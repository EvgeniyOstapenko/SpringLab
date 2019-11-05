package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private String INSERT = "insert into USERS (name, surname, email, number, password, subscription, userRole)"
            + " values(?,?,?,?,?,?,?)";
    private String GET_BY_EMAIL = "select id, name, surname, email, number, password,"
            + " subscription, userRole from USERS where email=?";
    private String GET_BY_ID = "select id, name, surname, email, number, password,"
            + " subscription, userRole from USERS where id=?";
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
    public User getByEmail(String email) {
        return jdbcTemplate.queryForObject(GET_BY_EMAIL, new UserRowMapper(), email);
    }

    @Override
    public User getById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, new UserRowMapper(), id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }
}
