package com.utangnaloob.utangnaloob.models;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private final int status;
    private final String error;
    private final String message;
    private final long timeStamp;

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
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

    public long getTimeStamp() {
        return timeStamp;
    }
}
