package com.ratz.limitsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.limitsservice.bean.Limits;

@RestController
public class LimitsController {

	
	@GetMapping(value = "/limits")
	public Limits getLimits() {
		return new Limits(1,1000);
	}
}
