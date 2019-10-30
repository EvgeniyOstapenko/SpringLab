package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.User;

public interface UserRepository {

    User saveUser(User user);

    User findUserByEmail(String email);

    User getUserById(Long id);

}
