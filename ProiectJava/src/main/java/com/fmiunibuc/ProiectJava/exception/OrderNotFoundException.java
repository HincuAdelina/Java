package com.fmiunibuc.ProiectJava.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(){
        super("No order found!");
    }
}
