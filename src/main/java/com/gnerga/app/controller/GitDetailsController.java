package com.gnerga.app.controller;

import com.gnerga.app.dto.GitHubDetailsDto;
import com.gnerga.app.dto.MessageDto;
import com.gnerga.app.service.GitHubDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Tag(name = "Github details", description = "Endpoint for get github details")
public class GitDetailsController {
    private final GitHubDetailsService service;

    @Operation(summary = "Get user repository",
            description = "Get user repository for given repository name",
            tags = {"Github details"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(schema =
                    @Schema(implementation = GitHubDetailsDto.class))),
            @ApiResponse(responseCode = "301",
                    description = "Repository moved permanently",
                    content = @Content(schema =
                    @Schema(implementation = MessageDto.class))),
            @ApiResponse(responseCode = "403",
                    description = "Forbidden access",
                    content = @Content(schema =
                    @Schema(implementation = MessageDto.class))),
            @ApiResponse(responseCode = "404",
                    description = "Repository not found",
                    content = @Content(schema =
                    @Schema(implementation = MessageDto.class)))
    })
    @GetMapping("/{owner}/{repo}")
    public GitHubDetailsDto getGitHubUserRepository(@PathVariable("owner") String owner, @PathVariable("repo") String repo) {
        return service.getRemoteUserRepository(owner, repo);
    }

    @Operation(summary = "List repositories for a user",
            description = "Lists public repositories for the specified user.",
            tags = {"Github details"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content(schema =
                    @Schema(implementation = GitHubDetailsDto.class))),
    })
    @GetMapping("/{owner}")
    public List<GitHubDetailsDto> getGitHubUserRepositories(@PathVariable("owner") String owner) {
        return service.getListUserRepositories(owner);
    }
}
