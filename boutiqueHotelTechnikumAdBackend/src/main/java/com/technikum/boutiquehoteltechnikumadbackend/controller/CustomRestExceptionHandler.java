package com.technikum.boutiquehoteltechnikumadbackend.controller;

import com.technikum.boutiquehoteltechnikumadbackend.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class CustomRestExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> handleNonExistingRoom(ResponseStatusException responseStatusException) {
        ApiError error = new ApiError(HttpStatus.valueOf(responseStatusException.getStatusCode().value()),
                responseStatusException.getReason());
        return new ResponseEntity<>(error, error.getStatus());
    }
}
