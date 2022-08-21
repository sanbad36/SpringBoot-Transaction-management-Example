package com.Sanket.SpringbootTransaction.exception;

public class PaymentException extends RuntimeException {
    public PaymentException(String message){
        super(message);
    }
}
