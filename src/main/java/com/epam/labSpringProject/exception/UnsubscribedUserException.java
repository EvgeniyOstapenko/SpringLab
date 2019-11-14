package com.epam.labSpringProject.exception;

public class UnsubscribedUserException extends RuntimeException{

    public UnsubscribedUserException(String message) {
        super(message);
    }
}
