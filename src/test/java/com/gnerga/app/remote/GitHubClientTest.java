package com.gnerga.app.remote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.gnerga.app.resources.GitHubResponseDtoTestFactory;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureWireMock(port = 80)
@NoArgsConstructor
@TestPropertySource(
        properties = {
                "spring.data.mongodb.username=root",
                "spring.data.mongodb.password=root",
                "spring.data.mongodb.database=mongo_db",
                "spring.data.mongodb.port=27017",
                "spring.data.mongodb.host=mongo_db",
                "spring.data.mongodb.authentication-database=admin"
        })
class GitHubClientTest {
    @Autowired
    WireMockServer wireMockServer;

    @Autowired
    GitHubClient gitHubClient;

    @Autowired
    ObjectMapper mapper;

    private static final String USERNAME = "superName";
    private static final String REPO_NAME = "super-repo";

    @Test
    void getUserRepos_returnsUserRepos() throws Exception {
        var expected = GitHubResponseDtoTestFactory.getReturnedList();

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/users/" + USERNAME + "/repos"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(mapper.writeValueAsString(expected))));

        var result = gitHubClient.getUserRepos(USERNAME);

        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/users/" + USERNAME + "/repos")));

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

    @Test
    void getUserRepo_returnsUserRepo() throws Exception {
        var expected = GitHubResponseDtoTestFactory.getGitHubResponseDto();

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/repos/" + USERNAME + "/" + REPO_NAME))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(mapper.writeValueAsString(expected))));

        var result = gitHubClient.getRepository(USERNAME, REPO_NAME);

        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/repos/" + USERNAME + "/" + REPO_NAME)));

        Assertions.assertEquals(expected.getFullName(), result.getFullName());
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
        Assertions.assertEquals(expected.getStars(), result.getStars());
        Assertions.assertEquals(expected.getCloneUrl(), result.getCloneUrl());
        Assertions.assertEquals(expected.getCreatedAt(), result.getCreatedAt());

    }

}