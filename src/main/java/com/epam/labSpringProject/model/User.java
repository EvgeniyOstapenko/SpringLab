package com.epam.labSpringProject.model;

import com.epam.labSpringProject.utility.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {
    private Long     id;
    private String   name;
    private String   surname;
    private String   email;
    private String   number;
    private String   password;
    private String   subscription;
    private UserRole userRole;

}
