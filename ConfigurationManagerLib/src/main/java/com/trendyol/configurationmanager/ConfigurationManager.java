package com.trendyol.configurationmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.trendyol.config.AppConfig;
import com.trendyol.model.Configuration;
import com.trendyol.service.ConfigService;

public class ConfigurationManager {
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationManager.class);

	private ConfigService configService;

	public static String mongoUrl;
	public static Integer refreshTimeInSeconds = 25;
	private String appName;

	public ConfigurationManager(String mongoUrl, String appName, Integer cacheRefreshTimeInSeconds) {
		logger.info("ConfigurationManager starting with params {},{},{}",
				new Object[] { mongoUrl, appName, cacheRefreshTimeInSeconds });
		ConfigurationManager.mongoUrl = mongoUrl;
		ConfigurationManager.refreshTimeInSeconds = cacheRefreshTimeInSeconds;
		this.appName = appName;

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		configService = context.getBean(ConfigService.class);
	}

	public <T> T getValue(String key) {
		if (key == null || key.isEmpty()) {
			return null;
		}
		Configuration cfg = configService.findByAppNameAndKey(appName, key);
		if (cfg != null) {
			String type = cfg.getType();
			String value = cfg.getValue();
			Object obj = getTypedObject(type, value);
			return (T) obj;
		} else {
			return null;
		}
	}

	private Object getTypedObject(String type, String value) {

		if ("Boolean".equalsIgnoreCase(type)) {
			if ("0".equals(value)) {
				return Boolean.FALSE;
			} else {
				return Boolean.TRUE;
			}
		} else if ("String".equalsIgnoreCase(type)) {
			return String.valueOf(value);
		} else if ("Integer".equalsIgnoreCase(type)) {
			return Integer.valueOf(value);
		} else if ("Double".equalsIgnoreCase(type)) {
			return Double.valueOf(value);
		} else {
			return null;
		}
	}

	public void test() {

		// System.out.println(cfg.getValue());
	}

}
