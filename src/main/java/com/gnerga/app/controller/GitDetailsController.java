package com.gnerga.app.controller;

import com.gnerga.app.dto.GitHubDetailsDto;
import com.gnerga.app.service.GitHubDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github-details")
public class GitDetailsController {
    private final GitHubDetailsService service;
    @GetMapping("/{owner}/{repo}")
    public GitHubDetailsDto getHitHubUserRepository(@PathVariable("owner")String owner, @PathVariable("repo") String repo) {
        return service.getUserRepo(owner, repo);
    }

}
