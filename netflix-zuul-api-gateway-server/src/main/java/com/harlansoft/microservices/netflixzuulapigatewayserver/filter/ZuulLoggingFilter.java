package com.harlansoft.microservices.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
//	this method tells if the filter should be applied to the current request
	@Override
	public boolean shouldFilter() {
		return true;
	}

//	filter logic
	@Override
	public Object run() throws ZuulException {
//		this only logs the request content
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("**** Logging request before forwarding ****");
		log.info("request -> {} uri -> {} remote ip -> {}", request, request.getRequestURI(), request.getRemoteAddr());
		return null;
	}

//	this indicates if the filtering should happen before or after the request is executed, or only error requests
//	-> "pre", "post", "error"
	@Override
	public String filterType() {
		return "pre";
	}

//	you can have multiple filters: security, logging, ....
//	this gives a priority score
	@Override
	public int filterOrder() {
		return 1;
	}

}
