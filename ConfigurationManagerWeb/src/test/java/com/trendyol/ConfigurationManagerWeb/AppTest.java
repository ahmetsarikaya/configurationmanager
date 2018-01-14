package com.trendyol.ConfigurationManagerWeb;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trendyol.model.Configuration;
import com.trendyol.model.Counter;
import com.trendyol.service.ConfigService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	ConfigService configService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAllConfig() {
		Assert.assertNotNull(configService.getAllConfigs());
	}

	@Test
	public void testCounterIsExists() {
		Assert.assertTrue(configService.isTableExists(Counter.class));
	}

	@Test
	public void testConfigurationIsExists() {
		Assert.assertTrue(configService.isTableExists(Configuration.class));
	}
}
