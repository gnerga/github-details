package com.gnerga.app.mapper;

import com.gnerga.app.resources.GitHubDetailsDtoTestFactory;
import com.gnerga.app.resources.GitHubResponseDtoTestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class GitHubDetailsMapperTest {
    GitHubDetailsMapper mapper = Mappers.getMapper(GitHubDetailsMapper.class);

    @Test
    void mapToDetails_returnGitHubDetailsDto() {
        var response = GitHubResponseDtoTestFactory.getGitHubResponseDto();
        var expected = GitHubDetailsDtoTestFactory.getGitHubDetailsDto();

        var result = mapper.mapToDetails(response);

        Assertions.assertEquals(expected.getFullName(), result.getFullName());
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
        Assertions.assertEquals(expected.getStars(), result.getStars());
        Assertions.assertEquals(expected.getCloneUrl(), result.getCloneUrl());
        Assertions.assertEquals(expected.getCreatedAt(), result.getCreatedAt());
    }
}