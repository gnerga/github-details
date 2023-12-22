package com.gnerga.app.controller;

import com.gnerga.app.dto.GitHubDetailsDto;
import com.gnerga.app.service.GitHubDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/")
@RequiredArgsConstructor
public class GitLocalDetailsController {
    private final GitHubDetailsService service;

    @PostMapping("/repositories/{owner}/{repo}")
    public GitHubDetailsDto saveLocalRepository(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    ) {
        return service.saveUserGitHubDetailsFromRemote(owner, repo);
    }

    @GetMapping("/local/repositories/{owner}/{repo}")
    public GitHubDetailsDto getLocalDetailsCopy(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    ) {
        return service.getLocalUserGitHubDetails(owner, repo);
    }

    @GetMapping("/repositories/{owner}/{repo}")
    public GitHubDetailsDto getRemoteDetailsCopy(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    ) {
        return service.getRemoteUserRepository(owner, repo);
    }

    @PutMapping("/repositories/{owner}/{repo}")
    public GitHubDetailsDto updateLocalRepository(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    ) {
        return service.saveUserGitHubDetailsFromRemote(owner, repo);
    }

    @DeleteMapping("/repositories/{owner}/{repo}")
    public void removeRemoteDetailsCopy(
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repo
    ) {
        service.deleteLocalUserGitHubDetails(owner, repo);
    }
}
