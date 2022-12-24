package com.fawry.foodorderingapi.exception;

public class ItemNotAvailableException extends RuntimeException{

    private static final long serialVersionUID = -1536188100082551548L;

    public ItemNotAvailableException(String s){
    super(s);
}
}
