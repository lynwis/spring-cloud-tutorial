package com.harlansoft.microservices.currencyconversionservice.services.exchange.bean;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CurrencyConversionResponse {
	
	@JsonAlias("exchangeValue")
	private CurrencyConversion currencyConversion;
	private int portNumber;
	
}
