package com.utangnaloob.utangnaloob.exceptions;

import com.utangnaloob.utangnaloob.models.ErrorResponse;
import com.utangnaloob.utangnaloob.models.FieldErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<List<FieldErrorResponse>>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();

        List<FieldErrorResponse> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorResponse(
                        error.getField(),
                        error.getDefaultMessage()
                ))
                .toList();

        ErrorResponse<List<FieldErrorResponse>> errorsResponse = new ErrorResponse<>(
                HttpStatus.BAD_REQUEST,
                "Request failed due to invalid or missing fields.",
                errors
        );

        return ResponseEntity
                .badRequest()
                .body(errorsResponse);
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
