package com.market.api.exception.configuration;

import com.market.api.exception.*;
import com.market.api.exception.responsemodel.ResponseModelBindException;
import com.market.api.exception.responsemodel.ResponseModelHasBeenPublished;
import com.market.api.exception.responsemodel.ResponseModelNotFoundException;
import com.market.api.exception.responsemodel.ResponseModelUserAlreadyExists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(ProductHasAlreadyBeenPublished.class)
    protected ResponseEntity<ResponseModelHasBeenPublished> handlePublishingConflict(Exception ex) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        ResponseModelHasBeenPublished responseModelHasBeenPublished = new ResponseModelHasBeenPublished(ex.getMessage(), LocalDateTime.now(), uri);
        return new ResponseEntity<>(responseModelHasBeenPublished, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    protected ResponseEntity<ResponseModelUserAlreadyExists> handleBadCredentials(UserAlreadyExists ex)
    {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("login", ex.getLogin());
        credentials.put("email", ex.getEmail());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        ResponseModelUserAlreadyExists userAlreadyExists = new ResponseModelUserAlreadyExists(ex.getMessage(),
                LocalDateTime.now(), uri, credentials);
        return new ResponseEntity<>(userAlreadyExists, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseModelBindException model = new ResponseModelBindException();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors() )
        {
            model.addErrorDetails(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(model, headers, status);
    }
}
