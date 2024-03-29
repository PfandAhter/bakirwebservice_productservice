package com.bakirwebservice.productservice.exceptions;


import lombok.Getter;

public class IllegalArgumentException extends Exception{

    @Getter
    private String message;

    public IllegalArgumentException( ){
        super();
        this.message = null;
    }
    public IllegalArgumentException(String message){
        super();
        this.message = message;
    }
}
