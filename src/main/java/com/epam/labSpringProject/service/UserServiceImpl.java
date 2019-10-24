package com.epam.labSpringProject.service;

import com.epam.labSpringProject.exception.EmailAlreadyExistException;
import com.epam.labSpringProject.exception.UserNotFoundException;
import com.epam.labSpringProject.exception.WrongPasswordException;
import com.epam.labSpringProject.model.User;
import com.epam.labSpringProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final Long ID = 1L;
    private final String KEY = "secret";

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User toRegister(String name, String surname, String email, String number, String password) {

        if(userRepository.findUserByEmail(email) != null)
            throw new EmailAlreadyExistException("This email is already in use");

        User user = new User(ID, name, surname, email, number, password, "");
        userRepository.saveUser(user);
        System.out.println(user.toString() + " has successfully signed up!");
        return user;
    }

    @Override
    public User toEnter(String email, String password) {
        User user;
        try{
            user = userRepository.findUserByEmail(email);
        }catch (NoSuchElementException e){
            throw new UserNotFoundException("Wrong email");
        }

        if (!password.equals(user.getPassword())) {
            throw new WrongPasswordException("Wrong password");
        }
        System.out.println(user.toString()
                                   + " successfully passed the check!");
        return user;
    }

    @Override
    public void subscribe(String email) {
        User user = userRepository.findUserByEmail(email);
        String generatedKey = DigestUtils.md5Hex(KEY);
        user.setSubscription(generatedKey);
    }
}
