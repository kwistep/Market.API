package com.market.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception{

    public ProductNotFoundException() {
        super("Product doesn't exist.");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
