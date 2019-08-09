package com.market.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends Exception {

    public ReviewNotFoundException() {
        super("Review doesn't exist.");
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
