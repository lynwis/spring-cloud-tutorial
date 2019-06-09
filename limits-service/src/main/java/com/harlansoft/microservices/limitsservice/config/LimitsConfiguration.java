package com.harlansoft.microservices.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("limits-service")
public class LimitsConfiguration {
	
	private int minimum;
	private int maximum;

}
