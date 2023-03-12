package com.example.demo.exception;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException() {
        super();
    }

    public AlreadyExistsException(String message) {
        super(message);
    }
}
