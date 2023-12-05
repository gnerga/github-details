package com.gnerga.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class GitHubDetailsDto {

    private final String fullName;
    private final String description;
    private final String cloneUrl;
    private final Integer stars;
    private final String createdAt;
}
