package com.gnerga.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class GitHubDetailsRuntimeException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final LocalDateTime timeStamp;

    public GitHubDetailsRuntimeException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.timeStamp = LocalDateTime.now();
    }
}
