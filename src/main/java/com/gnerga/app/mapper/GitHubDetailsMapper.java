package com.gnerga.app.mapper;

import com.gnerga.app.remote.model.GitHubResponseDto;
import com.gnerga.app.dto.GitHubDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
@Mapper(unmappedTargetPolicy =  ReportingPolicy.IGNORE, componentModel = "spring")
public interface GitHubDetailsMapper {
    @Mapping(source = "full_name", target = "fullName")
    @Mapping(source = "created_at", target = "createdAt")
    GitHubDetailsDto mapToDetails(GitHubResponseDto detailsDto);
}
