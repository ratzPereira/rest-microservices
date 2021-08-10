package com.ratz.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratz.currencyexchangeservice.entities.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
