package com.gnerga.app.service;

import com.gnerga.app.mapper.GitHubDetailsMapper;
import com.gnerga.app.remote.GitHubClient;
import com.gnerga.app.dto.GitHubDetailsDto;
import com.gnerga.app.remote.model.GitHubResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitHubDetailsService {
    private final GitHubClient gitHubClient;
    private final GitHubDetailsMapper mapper;
    public GitHubDetailsDto getUserRepo(String owner, String repo) {
        GitHubResponseDto response = gitHubClient.getRepository(owner, repo);
        return mapper.mapToDetails(response);
    }
}
