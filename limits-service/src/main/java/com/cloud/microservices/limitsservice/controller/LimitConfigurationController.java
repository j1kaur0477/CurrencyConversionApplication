package com.cloud.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.microservices.limitsservice.bean.LimitConfiguration;
import com.cloud.microservices.limitsservice.configurations.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retreiveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
		
	}
	
	@GetMapping("/limits-fault-tol")
	@HystrixCommand(fallbackMethod = "retriveFaultTol")
	public RuntimeException faultToleranceExaample() {
		return new RuntimeException("Not Avialble");		
	}
	
	public LimitConfiguration retriveFaultTol() {
		return new LimitConfiguration(3,3333);
	}


}
