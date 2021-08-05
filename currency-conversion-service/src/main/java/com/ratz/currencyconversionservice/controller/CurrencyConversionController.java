package com.ratz.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.currencyconversionservice.entities.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@GetMapping(value = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		return new CurrencyConversion(10001L, from, to, quantity, BigDecimal.valueOf(10),
				BigDecimal.valueOf(100), "dev");
	}

}
