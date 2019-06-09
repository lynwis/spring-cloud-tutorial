package com.harlansoft.microservices.limitsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harlansoft.microservices.limitsservice.config.LimitsConfiguration;
import com.harlansoft.microservices.limitsservice.services.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private LimitsConfiguration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(),
				configuration.getMinimum());
	}

}
