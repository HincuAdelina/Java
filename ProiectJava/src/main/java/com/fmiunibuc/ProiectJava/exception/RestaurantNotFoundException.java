package com.fmiunibuc.ProiectJava.exception;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(int id) {
        super("The restaurant with id: '" + id + "' does not exist.");
    }
    
}