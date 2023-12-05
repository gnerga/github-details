package com.gnerga.app.exception;

import org.springframework.http.HttpStatus;

public class RepositoryForbiddenAccessException extends GitHubDetailsRuntimeException {
    public RepositoryForbiddenAccessException() {
        super("Forbidden access", HttpStatus.FORBIDDEN);
    }
}
