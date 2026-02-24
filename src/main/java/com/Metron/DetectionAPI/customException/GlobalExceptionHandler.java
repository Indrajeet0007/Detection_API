package com.Metron.DetectionAPI.customException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidParameter.class)
    public ResponseEntity<String> handle (InvalidParameter ex){
        return ResponseEntity.status(500).body("Invalid Input :"+ex);

    }
}
