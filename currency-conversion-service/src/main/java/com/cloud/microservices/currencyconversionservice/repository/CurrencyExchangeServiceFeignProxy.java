package com.cloud.microservices.currencyconversionservice.repository;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloud.microservices.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-service", path = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceFeignProxy {

//	@GetMapping("/currency-exchange/from/{from}/to/{to}")	
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")

	
	public CurrencyConversionBean retreiveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
		
}
