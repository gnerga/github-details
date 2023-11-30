package com.gnerga.app.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class GitHubResponseDto {

    @JsonProperty("full_name")
    private final String fullName;
    private final String description;
    @JsonProperty("clone_url")
    private final String cloneUrl;
    @JsonProperty("stargazers_count")
    private final Integer stars;
    @JsonProperty("created_at")
    private final String createdAt;
}
