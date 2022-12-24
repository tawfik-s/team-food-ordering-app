package com.fawry.foodorderingapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<?> handleResourceNotFound(NoSuchElementException exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotAvailableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleItemNotAvailable(ItemNotAvailableException exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<?>handleMethodNotAllowed(MethodNotAllowedException exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false));
        return ResponseEntity.badRequest().body(response);
    }
}
