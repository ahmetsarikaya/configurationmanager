package com.trendyol.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.trendyol.model.Configuration;
import com.trendyol.model.Counter;

@Repository
public class ConfigRepository {
	private static final Logger logger = LoggerFactory.getLogger(ConfigRepository.class);
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Configuration> getAllConfigs() {
		logger.info("ConfigRepository.getAllConfigs()");
		return mongoTemplate.findAll(Configuration.class);
	}

	public <T> boolean isTableExists(Class<T> clazz) {
		logger.info("ConfigRepository.isTableExists({})", clazz.getName());
		String tabloName = mongoTemplate.getCollectionName(clazz);
		boolean isExist = tabloName == null ? false : true;
		if (isExist) {
			Query query = new Query();
			long count = mongoTemplate.count(query, clazz);
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public void saveCounter(Counter cnt) {
		logger.info("ConfigRepository.saveCounter()");
		mongoTemplate.save(cnt);
	}

	public void saveConfig(Configuration cfg) {
		logger.info("ConfigRepository.saveConfig()");
		cfg.setId(getMaxId());
		mongoTemplate.save(cfg);
	}

	public void updateConfig(Configuration cfg) {
		logger.info("ConfigRepository.updateConfig()");
		Query query = new Query(Criteria.where("id").is(cfg.getId()));
		Update update = new Update();
		update.set("name", cfg.getName());
		update.set("type", cfg.getType());
		update.set("value", cfg.getValue());
		update.set("applicationName", cfg.getApplicationName());
		mongoTemplate.updateFirst(query, update, Configuration.class);
	}

	public void deleteConfig(Configuration cfg) {
		logger.info("ConfigRepository.deleteConfig()");
		Query query = new Query(Criteria.where("id").is(cfg.getId()));
		mongoTemplate.findAndRemove(query, Configuration.class);
	}

	private Long getMaxId() {
		logger.info("ConfigRepository.getMaxId()");
		Query query = new Query();
		Update update = new Update();
		update.inc("seq", 1);
		Counter cnt = mongoTemplate.findAndModify(query, update, Counter.class);
		return cnt.getSeq();
	}
}
