package com.fawry.foodorderingapi.exception;

public class MethodNotAllowedException extends RuntimeException{

    public MethodNotAllowedException(String s){
        super(s);
    }
}
