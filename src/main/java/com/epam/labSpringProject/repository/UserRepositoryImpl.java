package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class UserRepositoryImpl implements UserRepository {

    private DataBase dataBase;
    private Long idCounter = 0L;

    @Autowired
    public UserRepositoryImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public User saveUser(User user) {
        dataBase.getUsersTable().add(idAutoIncrement(user));
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return dataBase.getUsersTable().stream()
                        .filter(user -> email.equals(user.getEmail()))
                        .findAny().orElse(null);
    }

    @Override
    public void subscribe(String userEmail, String key) {
        dataBase.getUsersTable().stream()
                .filter(user -> userEmail.equals(user.getEmail()))
                .forEach(user -> user.setSubscription(key));
    }

    private User idAutoIncrement(User user){
        user.setId(++idCounter);
        return user;
    }
}
