package com.epam.labSpringProject.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Task{
     private Long    id;
     private String  description;
     private boolean isDone;
     private Enum    priority;
     private Long    userId;
}
