package com.bert.test.test.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.springframework.http.HttpStatus;

public interface StockService {
	public Map<String, Map> getStock(String token) throws MalformedURLException, IOException;
	public HttpStatus getStock1(String token);
}