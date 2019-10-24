package com.epam.labSpringProject.repository;

import com.epam.labSpringProject.model.Task;
import com.epam.labSpringProject.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class DataBase {
    private List<Task>  taskRepository = new ArrayList<>();
    private List<User>  userRepository = new ArrayList<>();
}
