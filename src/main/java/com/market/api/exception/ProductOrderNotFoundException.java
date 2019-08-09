package com.market.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductOrderNotFoundException extends Exception {

    public ProductOrderNotFoundException() {
        super("Product order doesn't exist.");
    }

    public ProductOrderNotFoundException(String message) {
        super(message);
    }
}
