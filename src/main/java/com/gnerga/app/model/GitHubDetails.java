package com.gnerga.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("githubdetails")
@RequiredArgsConstructor
@Data
public class GitHubDetails {
    @Id
    private final String fullName;
    private final String description;
    private final String cloneUrl;
    private final Integer stars;
    private final String createdAt;
}
