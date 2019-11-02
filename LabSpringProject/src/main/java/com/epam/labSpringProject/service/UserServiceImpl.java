package com.epam.labSpringProject.service;

import com.epam.labSpringProject.exception.EmailAlreadyExistException;
import com.epam.labSpringProject.exception.UserNotFoundException;
import com.epam.labSpringProject.exception.WrongPasswordException;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.UserRepository;
import com.epam.security_module.SecurityService;
import com.epam.security_module.UnauthorizedAccessAttemptException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final String KEY = "secret";

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User toRegister(User currentUser) {
        if (userRepository.findUserByEmail(currentUser.getEmail()) != null)
            throw new EmailAlreadyExistException("This email is already in use");

        userRepository.saveUser(currentUser);
        System.out.println(currentUser.toString() + " has successfully signed up!");
        return currentUser;
    }

    @Override
    public User toEnter(User currentUser) {
        User user;
        try {
            user = userRepository.findUserByEmail(currentUser.getEmail());
        } catch (NoSuchElementException e) {
            throw new UserNotFoundException("Wrong email");
        }

        if (!currentUser.getPassword().equals(user.getPassword())) {
            throw new WrongPasswordException("Wrong password");
        }
        System.out.println(user.toString() + " successfully passed the check!");
        return user;
    }

    @Override
    public void subscribe(User currentUser) {
        User user = userRepository.findUserByEmail(currentUser.getEmail());
        String generatedKey = DigestUtils.md5Hex(KEY);
        user.setSubscription(generatedKey);
    }

    @Override
    public User getUserByUserId(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public void isAdminAuthority(SecurityService service, User user) {
        try {
            service.isValidUserRole(user.getUserRole());
            System.out.println("Welcome admin.");
        } catch (UnauthorizedAccessAttemptException e) {
            e.printStackTrace();
        }
    }
}
