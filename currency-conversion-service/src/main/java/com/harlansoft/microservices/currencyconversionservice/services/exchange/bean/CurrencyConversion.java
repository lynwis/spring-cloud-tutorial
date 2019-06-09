package com.harlansoft.microservices.currencyconversionservice.services.exchange.bean;

import java.math.BigDecimal;

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
public class CurrencyConversion {
	
	private String from;
	private String to;
	private BigDecimal conversionRate;
	private BigDecimal originalAmount;
	private BigDecimal convertedAmount;

}
