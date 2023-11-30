package com.gnerga.app.remote.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class GitHubResponseDto {

    final String full_name;
    final String description;
    final String cloneUrl;
    final Integer stars;
    final String created_at;
}
