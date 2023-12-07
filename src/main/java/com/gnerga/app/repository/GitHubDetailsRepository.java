package com.gnerga.app.repository;

import com.gnerga.app.model.GitHubDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface GitHubDetailsRepository extends MongoRepository<GitHubDetails, String> {
}
