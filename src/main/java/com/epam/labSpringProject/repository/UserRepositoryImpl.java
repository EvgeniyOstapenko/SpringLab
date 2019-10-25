package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class UserRepositoryImpl implements UserRepository {

    private MyDataBase myDataBase;
    private Long idCounter = 0L;

    @Autowired
    public UserRepositoryImpl(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }

    @Override
    public User saveUser(User user) {
        myDataBase.getUsersTable().add(idAutoIncrement(user));
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return myDataBase.getUsersTable().stream()
                        .filter(user -> email.equals(user.getEmail()))
                        .findAny().orElse(null);
    }

    // throw error "such user doesn't exist
    @Override
    public User getUserById(Long id) {
        return myDataBase.getUsersTable().stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst().orElse(null);
    }


    private User idAutoIncrement(User user){
        user.setId(++idCounter);
        return user;
    }
}
