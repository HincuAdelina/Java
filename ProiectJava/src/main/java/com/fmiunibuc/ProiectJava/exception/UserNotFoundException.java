package com.fmiunibuc.ProiectJava.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {

        super("The user with id: '" + id + "' does not exist.");
    }
    
}