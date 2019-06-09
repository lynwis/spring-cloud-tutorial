package com.harlansoft.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

// to call an existing service through the API gateway (like an external call), you have to invoke the zuul server at localhost:8765
// then, since it works using the naming server, you have to append the name of the application as it appears on the naming server
// then, the comoplete URI of the service, with context-root + params
// http://localhost:8765/<application-name>/<URI>
// http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/USD
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
//	imposta il sampling di tutte le request
//	serve per generare Id con Sleuth
//	NB non centra nulla con lo ZuulFilter!
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
