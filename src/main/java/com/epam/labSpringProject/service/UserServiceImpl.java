package com.epam.labSpringProject.service;

import com.epam.labSpringProject.exception.UserNotFoundException;
import com.epam.labSpringProject.exception.WrongPasswordException;
import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.JdbcUserRepositoryImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

//    @Qualifier("jdbcUserRepositoryImpl")
    private final JdbcUserRepositoryImpl userRepository;
    private final String KEY = "secret";

    @Autowired
    public UserServiceImpl(JdbcUserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User toRegister(User currentUser) {
//        if (jdbcUserRepositoryImpl.getByEmail(currentUser.getEmail()) != null)
//            throw new EmailAlreadyExistException("This email is already in use");

        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public User toEnter(User currentUser) {
        User user;
        try {
            user = userRepository.getByEmail(currentUser.getEmail());
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
    public List<Task> getAllUserTasks(User user) {
        return userRepository.getAllTasksByUserId(user.getId());
    }

    @Override
    public void isAdminAuthority(User user) {

    }

    @Override
    public void subscribe(User currentUser) {
        User user = userRepository.getByEmail(currentUser.getEmail());
        String generatedKey = DigestUtils.md5Hex(KEY);
        user.setSubscription(generatedKey);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.getById(userId);
    }

//    @Override
//    public void isAdminAuthority(User user) {
//        SecurityService service = getSecurityService();
//        try {
//            service.isValidUserRole(user.getUserRole());
//            System.out.println("Welcome admin.");
//        } catch (UnauthorizedAccessAttemptException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private SecurityService getSecurityService() {
//        ClassPathXmlApplicationContext xmlContext =
//                new ClassPathXmlApplicationContext("spring-config.xml");
//        xmlContext.refresh();
//        return xmlContext.getBean(SecurityService.class);
//    }
}
