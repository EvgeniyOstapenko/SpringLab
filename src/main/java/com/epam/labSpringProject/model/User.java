package com.epam.labSpringProject.model;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Long   id;
    private String name;
    private String surname;
    private String email;
    private String number;
    private String password;
    private String subscription;

//    @Override
//    public String toString() {
//        return "User: " + name;
//    }
}
