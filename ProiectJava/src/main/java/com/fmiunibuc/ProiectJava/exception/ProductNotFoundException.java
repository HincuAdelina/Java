package com.fmiunibuc.ProiectJava.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("No product found!");
    }
    
}