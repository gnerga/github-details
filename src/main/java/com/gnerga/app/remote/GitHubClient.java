package com.gnerga.app.remote;

import com.gnerga.app.configuration.FeignConfig;
import com.gnerga.app.remote.model.GitHubResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "github-client",
        url = "${spring.cloud.openfeign.client.config.github-client.url}",
        configuration = FeignConfig.class
)
public interface GitHubClient {
    @GetMapping("/users/{username}/repos")
    List<GitHubResponseDto> getUserRepos(@PathVariable("username") String username);

    @GetMapping("/repos/{owner}/{repo}")
    GitHubResponseDto getRepository(@PathVariable("owner") String owner,
                                              @PathVariable("repo") String repo);
}
