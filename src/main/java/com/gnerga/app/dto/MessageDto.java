package com.gnerga.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class MessageDto {
    private final HttpStatus httpStatus;
    private final String message;
    private final LocalDateTime timestamp;
}

