package com.gnerga.app.exception;

import org.springframework.http.HttpStatus;

public class RepositoryNotFoundException extends GitHubDetailsRuntimeException {
    public RepositoryNotFoundException() {
        super("Repository not found", HttpStatus.NOT_FOUND);
    }
}
