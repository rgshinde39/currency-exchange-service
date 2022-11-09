package com.example.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.example.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	
	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);

	
	@Autowired
	private Environment environment;
	
//	@Autowired
//	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		log.info("retriveExchangeValue with value {} to {}", from, to);
//		CurrencyExchange currencyExchange =  repository.findByFromAndTo(from, to);
		CurrencyExchange currencyExchange = new CurrencyExchange();
		currencyExchange.setId(1L);
		currencyExchange.setFrom("from test");
		currencyExchange.setTo("to test");
		String serverPort = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(serverPort);
//		
//		CurrencyExchange currencyExchange = CurrencyExchange.builder()
//				.id(1000l)
//				.from(from)
//				.to(to)
//				.conversionMultiple(BigDecimal.valueOf(50))
//				.environment(environment.getProperty("local.server.port"))
//				.build();
		return currencyExchange;
	}
}
