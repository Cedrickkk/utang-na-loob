package com.utangnaloob.utangnaloob.models;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.Instant;

public class ErrorResponse<T> {
    private final int status;
    private final String error;
    private final String message;
    private final Timestamp timeStamp;
    private final T details;

    public ErrorResponse(HttpStatus status, String message, T details) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.timeStamp = Timestamp.from(Instant.now());
        this.details = details;
    }

    public ErrorResponse(HttpStatus status, String message) {
        this(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public T getDetails() {
        return details;
    }
}