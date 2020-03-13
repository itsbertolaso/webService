package com.bert.test.test.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.springframework.http.HttpStatus;

public interface StockService {
	public Map<String, Map> getStock(String token) throws MalformedURLException, IOException;
	public Map<String, Map> getStock1(String token);
  public void updateStock(Map<String, Object> stock, String token);
}
