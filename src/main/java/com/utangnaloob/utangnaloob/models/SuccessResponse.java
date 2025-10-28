package com.utangnaloob.utangnaloob.models;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.Instant;

public class SuccessResponse<T> {
    private final int status;
    private final String message;
    private final Timestamp timestamp;
    private final T data;

    public SuccessResponse(HttpStatus status, String message, T data) {
        this.status = status.value();
        this.message = message;
        this.timestamp = Timestamp.from(Instant.now());
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }
}
