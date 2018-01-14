package com.trendyol.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.trendyol.model.Configuration;

@Repository
public class ConfigRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<Configuration> getAllConfigs() {
		return mongoTemplate.findAll(Configuration.class);
	}

	public Configuration findByAppNameAndKey(String appName, String key) {
		Query query = new Query(
				Criteria.where("name").is(key).and("applicationName").is(appName).and("active").is(Integer.valueOf(1)));

		return mongoTemplate.findOne(query, Configuration.class);
	}
}
