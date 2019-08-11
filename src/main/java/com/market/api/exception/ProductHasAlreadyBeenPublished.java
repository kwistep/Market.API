package com.market.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductHasAlreadyBeenPublished extends Exception {
    public ProductHasAlreadyBeenPublished(String message) {
        super(message);
    }

    public ProductHasAlreadyBeenPublished() {
        super("The problem has already been published!");
    }
}
