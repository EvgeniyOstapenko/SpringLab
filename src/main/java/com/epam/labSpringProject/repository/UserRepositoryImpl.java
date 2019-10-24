package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private DataBase dataBase;
    private Long idCounter = 0l;

    @Autowired
    public UserRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public User saveUser(User user) {
        System.out.println(dataBase.getUserRepository().toArray().length);
        dataBase.getUserRepository().add(idAutoIncrement(user));
        System.out.println(dataBase.getUserRepository().toArray().length);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user1 =  dataBase.getUserRepository().stream()
                        .filter(user -> email.equals(user.getPassword()))
                        .findAny().orElse(null);
        System.out.println(user1);
        return user1;
    }

    private User idAutoIncrement(User user){
        user.setId(++idCounter);
        return user;
    }
}
