package com.trendyol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigWebController {

	@GetMapping({ "/config", "/" })
	public String test() {
		return "config";
	}
}
