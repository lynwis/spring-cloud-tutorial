package com.harlansoft.microservices.currencyconversionservice.services.exchange.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harlansoft.microservices.currencyconversionservice.services.exchange.bean.CurrencyConversionResponse;

// a Feign proxy is needed to invoke an external microservice (the currency exchange srv)
// it's important to put here the NAME of the service (name of the spring application)

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
// once I start using Ribbon, I don't need the url anymore, I want to distribute the load between multiple instances
// with this, calls are routed to the target currency-conversion-service using its name to resolve the calls (through Eureka)
// if I want calls to be mediated by Zuul, I have to use its name as the target host
//@FeignClient(name="currency-exchange-service")
// like this, calls are intercepted by the Zuul proxy and then redirected to the service
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
//	this replaces the more verbose approach (and less object oriented) of using
//	RestTemplate directly in the service calling the other microservice
//	in this way, i'm hiding the details of the remote implementation: the clients
//	don't need to even know the remote service is a REST service
//	also, like this the calling logic is isolated (more SOLID)
	
//	commented out to use Zuul
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
//	to use Zuul, I need to use the application name in the URI
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionResponse retrieveExchangeValue(
			@PathVariable final String from,
			@PathVariable final String to);

}
