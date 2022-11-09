package com.example.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private static final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	//sample-apis - its a retry instance name, default one is 'default' with max 3 attempts
//	@Retry(name = "sample-apis", fallbackMethod = "hardcodedResponse")
	
	//to stop calling a down service again and again, we use circuit breaker, 
	//so after few failed attempts circuit breaker directly send back fallback response without even actually calling the API
	//more on this here: https://resilience4j.readme.io/docs/circuitbreaker, https://resilience4j.readme.io/docs/getting-started-3
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@GetMapping("/sample")
	public String sampleApi() {
		log.info("sample API");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("some-weird-url", String.class);
		return forEntity.getBody();
	}

	//use RateLimiter to limit max no of calls permitted to an API in a specified duration 
	@RateLimiter(name = "default")
	
	//use Bulkhead to limit max no of concurrent calls permitted to an API
	//@Bulkhead(name = "default")
	@GetMapping("/rate-limiter")
	public String rateLimiter() {
		log.info("rate limiter API");
		return "rate limiter API";
	}
	
	public String hardcodedResponse(Exception ex) {
		log.info("returned fallback response");
		return "fallback response";
	}
}
