package com.trendyol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig {
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClientURI mongoClientURI = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		return new SimpleMongoDbFactory(mongoClient, "test");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
}
