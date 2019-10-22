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
public class Task{
     private long    id;
     private String  description;
     private boolean isDone;
     private long    userId;
}
