package com.gnerga.app.resources;

import com.gnerga.app.dto.GitHubDetailsDto;

import java.util.List;

public class GitHubDetailsDtoTestFactory {
    public static GitHubDetailsDto getGitHubDetailsDto() {
        return GitHubDetailsDto.builder()
                .stars(5)
                .fullName("super-repo")
                .description("the best project around the world")
                .cloneUrl("https://github.com/gnerga/super-repo.git")
                .createdAt("2023-11-20T16:01:48Z")
                .build();
    }

    public static GitHubDetailsDto getGitHubDetailsDto_2() {
        return GitHubDetailsDto.builder()
                .stars(7)
                .fullName("super-repo-2")
                .description("the best project around the world 2")
                .cloneUrl("https://github.com/gnerga/super-repo-2.git")
                .createdAt("2023-11-20T16:01:48Z")
                .build();
    }

    public static List<GitHubDetailsDto> getReturnedList() {
        return List.of(getGitHubDetailsDto(), getGitHubDetailsDto_2());
    }
}
