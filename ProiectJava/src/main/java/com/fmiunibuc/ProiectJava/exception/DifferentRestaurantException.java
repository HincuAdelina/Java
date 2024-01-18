package com.fmiunibuc.ProiectJava.exception;

public class DifferentRestaurantException extends RuntimeException{

    public DifferentRestaurantException() {
        super("You cannot add products from different restaurants to your order.");
    }
}
