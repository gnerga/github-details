package com.gnerga.app.exception;

import org.springframework.http.HttpStatus;

public class RepositoryMovedPermanentlyException extends GitHubDetailsRuntimeException {
    public RepositoryMovedPermanentlyException() {
        super("Repository moved permanently", HttpStatus.MOVED_PERMANENTLY);
    }
}
