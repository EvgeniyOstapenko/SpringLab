package com.epam.labSpringProject.model;

import com.epam.labSpringProject.utility.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Task{
     private Long    id;
     private String  description;
     private boolean isDone;
     private TaskPriority priority;
     private Long    userId;
}
