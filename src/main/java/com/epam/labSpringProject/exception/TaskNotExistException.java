package com.epam.labSpringProject.exception;

public class TaskNotExistException extends RuntimeException{

    public TaskNotExistException(String message) {
        super(message);
    }
}