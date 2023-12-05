package com.gnerga.app.exception;

import com.gnerga.app.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GitHubDetailsExceptionHandler {
    @ExceptionHandler(RepositoryNotFoundException.class)
    public ResponseEntity<MessageDto> repositoryNotFoundException(
            RepositoryNotFoundException repositoryNotFoundException
    ) {
        return ResponseEntity.status(repositoryNotFoundException.getHttpStatus())
                .body(MessageDto.builder()
                        .httpStatus(repositoryNotFoundException.getHttpStatus())
                        .message(repositoryNotFoundException.getMessage())
                        .timestamp(repositoryNotFoundException.getTimeStamp())
                        .build()
                );
    }
}
