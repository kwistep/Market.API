package com.market.api.exception.configuration;

import com.market.api.exception.ProductNotFoundException;
import com.market.api.exception.ProductOrderNotFoundException;
import com.market.api.exception.ReviewNotFoundException;
import com.market.api.exception.UserNotFoundException;
import com.market.api.exception.responsemodel.ResponseModelBindException;
import com.market.api.exception.responsemodel.ResponseModelNotFoundException;
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

//    @ExceptionHandler(BindException.class)
//    protected ResponseEntity<ResponseModelBindException> handleBindException(BindException ex)
//    {
//
//        ResponseModelBindException model = new ResponseModelBindException();
//
//        for (FieldError fieldError : ex.getFieldErrors() )
//        {
//            model.addErrorDetails(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//
//        return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
//
//    }


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
