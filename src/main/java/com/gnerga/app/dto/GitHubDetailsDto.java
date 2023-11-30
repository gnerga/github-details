package com.gnerga.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class GitHubDetailsDto {

    final String fullName;
    final String description;
    final String cloneUrl;
    final Integer stars;
    final String createdAt;
}
