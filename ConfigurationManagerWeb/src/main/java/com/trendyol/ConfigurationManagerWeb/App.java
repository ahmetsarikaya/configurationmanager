package com.trendyol.ConfigurationManagerWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.trendyol.model.Configuration;
import com.trendyol.model.Counter;
import com.trendyol.service.ConfigService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.trendyol" })
public class App implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	@Autowired
	ConfigService configService;

	public static void main(String[] args) {
		logger.info("StandaloneWebApplication starting...");
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("MongoDb checking...");
		if (!configService.isTableExists(Counter.class)) {
			Counter cnt = new Counter();
			cnt.setId(0L);
			cnt.setSeq(0L);
			configService.saveCounter(cnt);
		}
		if (!configService.isTableExists(Configuration.class)) {

			Configuration cfg1 = new Configuration("SiteName", "String", "www.trendyol.com", 1, "SERVICE-A");
			Configuration cfg2 = new Configuration("IsBasketEnabled", "Boolean", "1", 1, "SERVICE-B");
			Configuration cfg3 = new Configuration("MaxItemCount", "Integer", "50", 0, "SERVICE-A");
			configService.saveConfiguration(cfg1);
			configService.saveConfiguration(cfg2);
			configService.saveConfiguration(cfg3);
		}
	}

}
