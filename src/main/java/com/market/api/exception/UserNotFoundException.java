package com.market.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {


    public UserNotFoundException() {
        super("User doesn't exist.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
