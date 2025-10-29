package com.utangnaloob.utangnaloob.exceptions;

import com.utangnaloob.utangnaloob.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String, String>>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

        ErrorResponse<Map<String, String>> errors = new ErrorResponse<>(
                HttpStatus.BAD_REQUEST,
                "Request failed due to invalid or missing fields.",
                fieldErrors
        );

        return ResponseEntity
                .badRequest()
                .body(errors);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse<Void>> handleItemNotFoundException(ItemNotFoundException exception) {
        ErrorResponse<Void> errorResponse = new ErrorResponse<>(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DebtorNotFoundException.class)
    public ResponseEntity<ErrorResponse<Void>> handleDebtorNotFoundException(DebtorNotFoundException exception) {
        ErrorResponse<Void> errorResponse = new ErrorResponse<>(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DebtNotFoundException.class)
    public ResponseEntity<ErrorResponse<Void>> handleItemNotFoundException(DebtNotFoundException exception) {
        ErrorResponse<Void> errorResponse = new ErrorResponse<>(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
