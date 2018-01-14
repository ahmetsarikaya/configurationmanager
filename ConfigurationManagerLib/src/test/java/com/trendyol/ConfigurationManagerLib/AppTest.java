package com.trendyol.ConfigurationManagerLib;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.trendyol.config.AppConfig;
import com.trendyol.configurationmanager.ConfigurationManager;
import com.trendyol.model.Configuration;
import com.trendyol.service.ConfigService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AppTest {
	@Autowired
	ConfigService configService;

	@Test
	public void testGetValue() {
		ConfigurationManager cm = new ConfigurationManager("mongodb://localhost:27017", "SERVICE-A", 20);
		Assert.assertEquals("www.trendyol.com", cm.getValue("SiteName"));
	}

	@Test
	public void testFindConfiguration() {
		Configuration cfg = configService.findByAppNameAndKey("SERVICE-A", "SiteName");
		Assert.assertEquals("www.trendyol.com", cfg.getValue());
	}
}
