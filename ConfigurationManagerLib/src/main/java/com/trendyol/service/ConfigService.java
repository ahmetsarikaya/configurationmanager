package com.trendyol.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.trendyol.model.Configuration;
import com.trendyol.repository.ConfigRepository;

@Service
@CacheConfig(cacheNames = "configs")
public class ConfigService {
	private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

	@Autowired
	ConfigRepository configRepository;
	Map<String, Object> previousDataMap = new HashMap<String, Object>();

	@Cacheable
	public Configuration findByAppNameAndKey(String appName, String key) {
		logger.info("findByAppNameAndKey method calling with {},{}", appName, key);
		Configuration cfg = null;
		try {
			cfg = configRepository.findByAppNameAndKey(appName, key);
			previousDataMap.put(appName + "_" + key, cfg);
			return cfg;
		} catch (Exception e) {
			logger.error("findByAppNameAndKey method failed hata:{}", e.getMessage());
			return (Configuration) previousDataMap.get(appName + "_" + key);
		}
	}
}
