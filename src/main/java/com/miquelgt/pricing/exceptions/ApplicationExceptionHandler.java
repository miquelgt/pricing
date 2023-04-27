package com.miquelgt.pricing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> serverExceptionHandler(Exception ex, ServerHttpRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorDTO> buildErrorResponse(Exception ex, ServerHttpRequest request, HttpStatus status) {
        return ResponseEntity.status(status)
                .body(new ErrorDTO(ex.getMessage(), request, status));
    }


}
