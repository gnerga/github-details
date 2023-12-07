package com.gnerga.app.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.gnerga.app.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.authentication-database}")
    private String authentication;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.port}")
    private String port;
    @Value("${spring.data.mongodb.host}")
    private String host;

    @Override
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(username,
                authentication,
                password.toCharArray()
        );
        ConnectionString connectionString = new ConnectionString(
                String.format("mongodb://%s:%s/%s",
                        host,
                        port,
                        database
                ));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .credential(credential)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "mongo_db";
    }
}