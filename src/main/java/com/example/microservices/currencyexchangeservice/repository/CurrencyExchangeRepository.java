package com.example.microservices.currencyexchangeservice.repository;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.currencyexchangeservice.entity.CurrencyExchange;

//public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
public interface CurrencyExchangeRepository {
	CurrencyExchange findByFromAndTo(String from, String to);
}
