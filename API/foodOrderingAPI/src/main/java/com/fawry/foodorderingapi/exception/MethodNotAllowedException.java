package com.fawry.foodorderingapi.exception;

public class MethodNotAllowedException extends RuntimeException{

    private static final long serialVersionUID = 2360447573119785178L;

    public MethodNotAllowedException(String s){
        super(s);
    }
}
