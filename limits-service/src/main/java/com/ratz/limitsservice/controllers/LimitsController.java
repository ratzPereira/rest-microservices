package com.ratz.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.limitsservice.bean.Limits;
import com.ratz.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration config;
	
	
	@GetMapping(value = "/limits")
	public Limits getLimits() {
		return new Limits(config.getMinimun(),config.getMaximun());
	}
}
