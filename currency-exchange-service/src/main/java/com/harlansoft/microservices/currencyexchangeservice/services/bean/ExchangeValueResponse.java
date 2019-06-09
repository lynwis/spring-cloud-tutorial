package com.harlansoft.microservices.currencyexchangeservice.services.bean;

import com.harlansoft.microservices.currencyexchangeservice.model.ExchangeValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeValueResponse {
	
	private ExchangeValue exchangeValue;
	private int portNumber;

}
