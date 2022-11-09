package com.example.microservices.currencyexchangeservice.entity;

import java.math.BigDecimal;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@NoArgsConstructor
//@Entity
public class CurrencyExchange {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "currency_from")
	private String from;
	
//	@Column(name = "currency_to")
	private String to;
	
//	@Column
	private BigDecimal conversionMultiple;
	
//	@Column
	private String environment;
}
