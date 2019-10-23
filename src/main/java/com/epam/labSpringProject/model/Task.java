package com.epam.labSpringProject.model;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task{
     private Long    id;
     private String  description;
     private boolean isDone;
     private long    userId;
}
