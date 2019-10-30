package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
class MyDataBase {
    private List<Task> tasksTable = new ArrayList<>();
    private List<User> usersTable = new ArrayList<>();
}
