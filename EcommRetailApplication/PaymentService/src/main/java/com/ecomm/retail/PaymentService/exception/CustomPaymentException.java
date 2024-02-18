package com.ecomm.retail.PaymentService.exception;

public class CustomPaymentException  extends RuntimeException{
    private String errorCode;
    public CustomPaymentException(String errorCode,String message){
        super(message);
        this.errorCode=errorCode;

    }


}
