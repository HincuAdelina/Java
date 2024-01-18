package com.fmiunibuc.ProiectJava.exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException() {
        super("No driver found!");
    }
}
