package com.epam.security_module;

public class UnauthorizedAccessAttemptException extends Exception {

    UnauthorizedAccessAttemptException(String message) {
        super(message);
    }

}
