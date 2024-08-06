package com.bakirwebservice.stockservice.exceptions;

import lombok.Getter;

public class OutOfStockException extends Exception{

    @Getter
    private final String message;

    public OutOfStockException( ){
        super();
        this.message = null;
    }
    public OutOfStockException(String message){
        super();
        this.message = message;
    }
}
