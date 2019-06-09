package com.harlansoft.microservices.zipkindistributedtracingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;


@EnableZipkinServer
@SpringBootApplication
public class ZipkinDistributedTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDistributedTracingServerApplication.class, args);
	}
//
//	@Bean
//	ServletWebServerFactory servletWebServerFactory() {
//		return new TomcatServletWebServerFactory();
//	}

//	@Bean
//	public UndertowServletWebServerFactory embeddedServletContainerFactory() {
//		UndertowServletWebServerFactory factory = 
//	      new UndertowServletWebServerFactory();
//	     
//	    factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//	        @Override
//	        public void customize(io.undertow.Undertow.Builder builder) {
//	            builder.addHttpListener(8080, "0.0.0.0");
//	        }
//	    });
//	     
//	    return factory;
//	}

}
