package com.harlansoft.microservices.currencyconversionservice.services.exchange;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.harlansoft.microservices.currencyconversionservice.services.exchange.bean.CurrencyConversion;
import com.harlansoft.microservices.currencyconversionservice.services.exchange.bean.CurrencyConversionResponse;
import com.harlansoft.microservices.currencyconversionservice.services.exchange.proxy.CurrencyExchangeServiceProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeProxy;
	
	// this will get the two currencies in input along with the amount
	// will call the exchange service to get the exchange rate
	// and will return the conversion
	@GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionResponse convertCurrency(@PathVariable final String from,
			@PathVariable final String to, @PathVariable final BigDecimal amount) {
		
//		to get ExchangeValue
//		{
//		    "exchangeValue": {
//		        "id": 1001,
//		        "from": "USD",
//		        "to": "EUR",
//		        "conversionRate": 0.9
//		    },
//		    "portNumber": 8000
//		}
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionResponse> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionResponse.class, uriVariables);
		
		CurrencyConversionResponse response = responseEntity.getBody();
		
		return CurrencyConversionResponse.builder()
				.currencyConversion(CurrencyConversion.builder()
						.from(from)
						.to(to)
						.conversionRate(response.getCurrencyConversion().getConversionRate())
						.originalAmount(amount)
						.convertedAmount(amount.multiply(response.getCurrencyConversion().getConversionRate()))
						.build()
				)
				.portNumber(response.getPortNumber())
				.build();
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionResponse convertCurrencyFeignClient(@PathVariable final String from,
			@PathVariable final String to, @PathVariable final BigDecimal amount) {
		
		CurrencyConversionResponse response = currencyExchangeProxy.retrieveExchangeValue(from, to);
		
		log.info("{}", response);
		
		return CurrencyConversionResponse.builder()
				.currencyConversion(CurrencyConversion.builder()
						.from(from)
						.to(to)
						.conversionRate(response.getCurrencyConversion().getConversionRate())
						.originalAmount(amount)
						.convertedAmount(amount.multiply(response.getCurrencyConversion().getConversionRate()))
						.build()
				)
				.portNumber(response.getPortNumber())
				.build();
	}

}
