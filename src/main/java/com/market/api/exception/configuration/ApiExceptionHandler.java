package com.market.api.exception.configuration;

import com.market.api.exception.ProductNotFoundException;
import com.market.api.exception.ProductOrderNotFoundException;
import com.market.api.exception.ReviewNotFoundException;
import com.market.api.exception.UserNotFoundException;
import com.market.api.exception.responsemodel.ResponseModelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            UserNotFoundException.class,
            ReviewNotFoundException.class,
            ProductNotFoundException.class,
            ProductOrderNotFoundException.class
    })
    protected ResponseEntity<ResponseModelNotFoundException> handleResourceNotFound(Exception ex) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        ResponseModelNotFoundException responseModelNotFoundException = new ResponseModelNotFoundException(ex.getMessage(), LocalDateTime.now(), uri);
        return new ResponseEntity<>(responseModelNotFoundException, HttpStatus.NOT_FOUND);
    }


}
