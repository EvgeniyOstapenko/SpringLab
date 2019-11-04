package com.epam.labSpringProject.service;

import com.epam.labSpringProject.exception.UserNotFoundException;
import com.epam.labSpringProject.exception.WrongPasswordException;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.*;
import com.epam.security_module.SecurityService;
import com.epam.security_module.UnauthorizedAccessAttemptException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

//    @Qualifier("jdbcUserRepositoryImpl")
    private final JdbcUserRepositoryImpl jdbcUserRepositoryImpl;
    private final String KEY = "secret";

    @Autowired
    public UserServiceImpl(JdbcUserRepositoryImpl userRepository) {
        this.jdbcUserRepositoryImpl = userRepository;
    }

    @Override
    public User toRegister(User currentUser) {
//        if (jdbcUserRepositoryImpl.findByEmail(currentUser.getEmail()) != null)
//            throw new EmailAlreadyExistException("This email is already in use");

        jdbcUserRepositoryImpl.save(currentUser);
        System.out.println(currentUser.toString() + " has successfully signed up!");
        return currentUser;
    }

    @Override
    public User toEnter(User currentUser) {
        User user;
        try {
            user = jdbcUserRepositoryImpl.getByEmail(currentUser.getEmail());
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
        User user = jdbcUserRepositoryImpl.getByEmail(currentUser.getEmail());
        String generatedKey = DigestUtils.md5Hex(KEY);
        user.setSubscription(generatedKey);
    }

    @Override
    public User getById(Long userId) {
        return jdbcUserRepositoryImpl.getById(userId);
    }

    @Override
    public void isAdminAuthority(User user) {
        SecurityService service = getSecurityService();
        try {
            service.isValidUserRole(user.getUserRole());
            System.out.println("Welcome admin.");
        } catch (UnauthorizedAccessAttemptException e) {
            e.printStackTrace();
        }
    }

    private SecurityService getSecurityService() {
        ClassPathXmlApplicationContext xmlContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        xmlContext.refresh();
        return xmlContext.getBean(SecurityService.class);
    }
}
