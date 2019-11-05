package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User getByEmail(String email);

    User getById(Long id);

    List<User> findAll();

}
