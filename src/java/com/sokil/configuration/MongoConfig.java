package com.sokil.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@ComponentScan(basePackages = "com.sokil")
@PropertySource("classpath:mongo_db.properties")
public class MongoConfig {
    @Value("${mongoDB.URL}")
    private String url;
    @Value("${mongoDB.dbName}")
    private String dbName;

    @Bean
    public MongoClientURI mongoClientURI(){
        return new MongoClientURI(url);
    }

    @Bean
    public MongoClient mongoClient(){
        return new MongoClient(mongoClientURI());
    }

    @Bean
    public SimpleMongoDbFactory simpleMongoDbFactory(){
        return new SimpleMongoDbFactory(mongoClient(), dbName);
    }

    @Bean(name = "mongoTemplate")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(simpleMongoDbFactory());
    }
}
