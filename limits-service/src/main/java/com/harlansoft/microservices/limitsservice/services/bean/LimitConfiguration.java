package com.harlansoft.microservices.limitsservice.services.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LimitConfiguration {
	
	private int maximum;
	private int minimum;

}
