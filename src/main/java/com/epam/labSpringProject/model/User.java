package com.epam.labSpringProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long   id;
    private String name;
    private String surname;
    private String email;
    private String password;


}
