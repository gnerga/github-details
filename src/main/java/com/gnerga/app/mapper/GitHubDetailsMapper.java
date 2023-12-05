package com.gnerga.app.mapper;

import com.gnerga.app.remote.model.GitHubResponseDto;
import com.gnerga.app.dto.GitHubDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface GitHubDetailsMapper {
    GitHubDetailsDto mapToDetails(GitHubResponseDto responseDto);
}
