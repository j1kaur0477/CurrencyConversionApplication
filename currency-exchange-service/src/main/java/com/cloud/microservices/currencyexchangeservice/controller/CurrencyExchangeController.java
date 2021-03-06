package com.cloud.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.cloud.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	private static final Logger LOGGER = Logger.getLogger( CurrencyExchangeController.class.getName());

	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue=exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		LOGGER.info(exchangeValue+"-------------------------------------------------------");
		return exchangeValue;
	}

}
