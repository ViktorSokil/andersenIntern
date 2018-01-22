package com.sokil.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@ComponentScan(basePackages = "com.sokil")
public class MongoConfig {
    private static final String URI = "mongodb+srv://viksokil:270487@viktorclaster-uioz9.mongodb.net/test";
    private static final String DB_NAME = "persons";

    @Bean
    public MongoClientURI mongoClientURI(){
        return new MongoClientURI(URI);
    }

    @Bean
    public MongoClient mongoClient(){
        return new MongoClient(mongoClientURI());
    }

    @Bean
    public SimpleMongoDbFactory simpleMongoDbFactory(){
        return new SimpleMongoDbFactory(mongoClient(), DB_NAME);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(simpleMongoDbFactory());
    }
}
