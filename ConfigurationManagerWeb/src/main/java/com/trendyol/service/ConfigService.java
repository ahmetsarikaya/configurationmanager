package com.trendyol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendyol.model.Configuration;
import com.trendyol.model.Counter;
import com.trendyol.repository.ConfigRepository;

@Service
public class ConfigService {
	@Autowired
	ConfigRepository configRepository;

	public List<Configuration> getAllConfigs() {
		return configRepository.getAllConfigs();
	}

	public <T> boolean isTableExists(Class<T> clazz) {
		return configRepository.isTableExists(clazz);
	}

	public void saveCounter(Counter cnt) {
		configRepository.saveCounter(cnt);
	}

	public void saveConfiguration(Configuration cfg) {
		configRepository.saveConfig(cfg);
	}
}
