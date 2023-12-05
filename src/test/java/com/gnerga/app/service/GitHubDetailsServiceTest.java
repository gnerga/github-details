package com.gnerga.app.service;

import com.gnerga.app.mapper.GitHubDetailsMapper;
import com.gnerga.app.remote.GitHubClient;
import com.gnerga.app.resources.GitHubDetailsDtoTestFactory;
import com.gnerga.app.resources.GitHubResponseDtoTestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class GitHubDetailsServiceTest {
    private GitHubClient gitHubClient;
    private GitHubDetailsMapper gitHubDetailsMapper;
    private GitHubDetailsService gitHubDetailsService;
    private static final String USERNAME = "superName";
    private static final String REPO_NAME = "super-repo";

    @BeforeEach
    void setup() {
        this.gitHubClient = Mockito.mock(GitHubClient.class);
        this.gitHubDetailsMapper = Mappers.getMapper(GitHubDetailsMapper.class);
        this.gitHubDetailsService = new GitHubDetailsService(gitHubClient, gitHubDetailsMapper);
    }

    @Test
    void getUserRepo_repositoryExist_returnsGitHubResponseDto() {
        var response = GitHubResponseDtoTestFactory.getGitHubResponseDto();
        var expected = GitHubDetailsDtoTestFactory.getGitHubDetailsDto();
        Mockito.when(gitHubClient.getRepository(USERNAME, REPO_NAME)).thenReturn(response);

        var result = gitHubDetailsService.getUserRepo(USERNAME, REPO_NAME);

        Assertions.assertEquals(expected.getFullName(), result.getFullName());
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
        Assertions.assertEquals(expected.getStars(), result.getStars());
        Assertions.assertEquals(expected.getCloneUrl(), result.getCloneUrl());
        Assertions.assertEquals(expected.getCreatedAt(), result.getCreatedAt());
    }

    @Test
    void getUserRepos_repositoriesExist_returnsGitHubResponseDtoList() {
        var response = GitHubResponseDtoTestFactory.getReturnedList();
        var expected = GitHubDetailsDtoTestFactory.getReturnedList();
        Mockito.when(gitHubClient.getUserRepos(USERNAME)).thenReturn(response);

        var result = gitHubDetailsService.getUserRepos(USERNAME);

        Assertions.assertEquals(expected.get(0).getFullName(), result.get(0).getFullName());
        Assertions.assertEquals(expected.get(0).getDescription(), result.get(0).getDescription());
        Assertions.assertEquals(expected.get(0).getStars(), result.get(0).getStars());
        Assertions.assertEquals(expected.get(0).getCloneUrl(), result.get(0).getCloneUrl());
        Assertions.assertEquals(expected.get(0).getCreatedAt(), result.get(0).getCreatedAt());

        Assertions.assertEquals(expected.get(1).getFullName(), result.get(1).getFullName());
        Assertions.assertEquals(expected.get(1).getDescription(), result.get(1).getDescription());
        Assertions.assertEquals(expected.get(1).getStars(), result.get(1).getStars());
        Assertions.assertEquals(expected.get(1).getCloneUrl(), result.get(1).getCloneUrl());
        Assertions.assertEquals(expected.get(1).getCreatedAt(), result.get(1).getCreatedAt());
    }
}