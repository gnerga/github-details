package com.gnerga.app.service;

import com.gnerga.app.mapper.GitHubDetailsMapper;
import com.gnerga.app.remote.GitHubClient;
import com.gnerga.app.dto.GitHubDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GitHubDetailsService {
    private final GitHubClient gitHubClient;
    private final GitHubDetailsMapper mapper;

    public GitHubDetailsDto getUserRepo(String owner, String repo) {
        var response = gitHubClient.getRepository(owner, repo);
        return mapper.mapToDetails(response);
    }

    public List<GitHubDetailsDto> getUserRepos(String owner) {
        var gitHubResponse = gitHubClient.getUserRepos(owner);
        return gitHubResponse.stream()
                .map(mapper::mapToDetails)
                .collect(Collectors.toList());
    }
}
