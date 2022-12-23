package com.example.product_catalog_api.Exceptions;

import com.fawry.foodorderingapi.exception.GroupNotFoundException;
import com.fawry.foodorderingapi.exception.RestaurantNotFoundException;
import com.fawry.foodorderingapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = GroupNotFoundException.class)
    public ResponseEntity<Object> exception(GroupNotFoundException exception) {
        return new ResponseEntity<>("Group not found", HttpStatus.NOT_FOUND);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found error", HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = RestaurantNotFoundException.class)
    public ResponseEntity<Object> exception(RestaurantNotFoundException exception) {
        return new ResponseEntity<>("Restaurant not found error", HttpStatus.NOT_FOUND);
    }

}