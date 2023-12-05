package com.gnerga.app.resources;

import com.gnerga.app.remote.model.GitHubResponseDto;

import java.util.List;

public class GitHubResponseDtoTestFactory {
    public static GitHubResponseDto getGitHubResponseDto() {
        return GitHubResponseDto.builder()
                .stars(5)
                .fullName("super-repo")
                .description("the best project around the world")
                .cloneUrl("https://github.com/gnerga/super-repo.git")
                .createdAt("2023-11-20T16:01:48Z")
                .build();
    }

    public static GitHubResponseDto getGitHubResponseDto_2() {
        return GitHubResponseDto.builder()
                .stars(7)
                .fullName("super-repo-2")
                .description("the best project around the world 2")
                .cloneUrl("https://github.com/gnerga/super-repo-2.git")
                .createdAt("2023-11-20T16:01:48Z")
                .build();
    }

    public static List<GitHubResponseDto> getReturnedList() {
        return List.of(getGitHubResponseDto(), getGitHubResponseDto_2());
    }
}
