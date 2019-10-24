package com.epam.labSpringProject.exception;

public class EmailNotExistsException extends RuntimeException {

    public EmailNotExistsException(String message) {
        super(message);
    }
}
