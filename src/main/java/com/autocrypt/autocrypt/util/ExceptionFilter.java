package com.autocrypt.autocrypt.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionFilter {
    @ExceptionHandler(value = { IllegalArgumentException.class })
    public ResponseEntity<Object> handleApiRequestException(IllegalArgumentException ex) {
        Exception exception = new Exception();
        exception.setHttpStatus(HttpStatus.BAD_REQUEST);
        exception.setErrorMessage(ex.getMessage());

        return new ResponseEntity(
                exception,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = { NullPointerException.class })
    public ResponseEntity<Object> handleApiRequestException(NullPointerException ex) {
        Exception exception = new Exception();
        exception.setHttpStatus(HttpStatus.BAD_REQUEST);
        exception.setErrorMessage(ex.getMessage());

        return new ResponseEntity(
                exception,
                HttpStatus.BAD_REQUEST
        );
    }

}
