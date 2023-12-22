package com.gnerga.app.service;

import com.gnerga.app.exception.RepositoryNotFoundException;
import com.gnerga.app.mapper.GitHubDetailsMapper;
import com.gnerga.app.remote.GitHubClient;
import com.gnerga.app.dto.GitHubDetailsDto;
import com.gnerga.app.repository.GitHubDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GitHubDetailsService {
    private final GitHubClient gitHubClient;
    private final GitHubDetailsMapper mapper;
    private final GitHubDetailsRepository repository;

    public GitHubDetailsDto getRemoteUserRepository(String owner, String repo) {
        var response = gitHubClient.getRepository(owner, repo);
        return mapper.mapToDetails(response);
    }

    public List<GitHubDetailsDto> getListUserRepositories(String owner) {
        var gitHubResponse = gitHubClient.getUserRepos(owner);
        return gitHubResponse.stream()
                .map(mapper::mapToDetails)
                .collect(Collectors.toList());
    }

    public GitHubDetailsDto getLocalUserGitHubDetails(String owner, String repo) {
        var record = repository.findById(returnId(owner, repo))
                .orElseThrow(RepositoryNotFoundException::new);
        return mapper.mapModelToDto(record);
    }

    public GitHubDetailsDto saveUserGitHubDetailsFromRemote(String owner, String repo) {
        var response = getRemoteUserRepository(owner, repo);
        var record = mapper.mapDetailsToModel(response);
        repository.save(record);
        return mapper.mapModelToDto(record);
    }

    public void deleteLocalUserGitHubDetails(String owner, String repo) {
        var record = repository.findById(returnId(owner, repo))
                .orElseThrow(RepositoryNotFoundException::new);
        repository.delete(record);
    }

    private String returnId(String owner, String repo) {
        return String.format("%s/%s", owner, repo);
    }
}
