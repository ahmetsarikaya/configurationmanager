package com.trendyol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trendyol.model.Configuration;
import com.trendyol.repository.ConfigRepository;

@RestController
public class ConfigRestController {
	@Autowired
	private ConfigRepository configRepository;

	@RequestMapping(value = "/data/all-configs", method = RequestMethod.GET)
	public List<Configuration> getAllConfig() {
		return configRepository.getAllConfigs();
	}
}
