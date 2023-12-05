package com.gnerga.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnerga.app.remote.GitHubClient;
import com.gnerga.app.resources.GitHubDetailsDtoTestFactory;
import com.gnerga.app.resources.GitHubResponseDtoTestFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GitDetailsControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GitHubClient gitHubClient;
    private static final String USERNAME = "superName";
    private static final String REPO_NAME = "super-repo";

    @Test
    void getGitHubUserRepository() throws Exception {
        var response = GitHubResponseDtoTestFactory.getGitHubResponseDto();
        var expected = GitHubDetailsDtoTestFactory.getGitHubDetailsDto();

        Mockito.when(gitHubClient.getRepository(USERNAME, REPO_NAME)).thenReturn(response);

        mockMvc.perform(get("/{owner}/{repo}", USERNAME, REPO_NAME))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value(expected.getFullName()))
                .andExpect(jsonPath("$.description").value(expected.getDescription()))
                .andExpect(jsonPath("$.cloneUrl").value(expected.getCloneUrl()))
                .andExpect(jsonPath("$.stars").value(expected.getStars()))
                .andExpect(jsonPath("$.createdAt").value(expected.getCreatedAt()));
    }

    @Test
    void getGitHubUserRepositories() throws Exception {
        var response = GitHubResponseDtoTestFactory.getReturnedList();
        var expected = GitHubDetailsDtoTestFactory.getReturnedList();

        Mockito.when(gitHubClient.getUserRepos(USERNAME)).thenReturn(response);

        mockMvc.perform(get("/{owner}", USERNAME))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value(expected.get(0).getFullName()))
                .andExpect(jsonPath("$[0].description").value(expected.get(0).getDescription()))
                .andExpect(jsonPath("$[0].cloneUrl").value(expected.get(0).getCloneUrl()))
                .andExpect(jsonPath("$[0].stars").value(expected.get(0).getStars()))
                .andExpect(jsonPath("$[0].createdAt").value(expected.get(0).getCreatedAt()))
                .andExpect(jsonPath("$[1].fullName").value(expected.get(1).getFullName()))
                .andExpect(jsonPath("$[1].description").value(expected.get(1).getDescription()))
                .andExpect(jsonPath("$[1].cloneUrl").value(expected.get(1).getCloneUrl()))
                .andExpect(jsonPath("$[1].stars").value(expected.get(1).getStars()))
                .andExpect(jsonPath("$[1].createdAt").value(expected.get(1).getCreatedAt()));
    }
}