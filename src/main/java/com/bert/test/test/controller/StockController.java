package com.bert.test.test.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.StockDto;
import com.bert.test.test.services.StockService;
import com.bert.test.test.services.UserService;

@RestController
@RequestMapping(value = "api/stock", produces = "application/json")
public class StockController {

  @Autowired
  UserService userService;
  @Autowired
  StockService stockService;

  @GetMapping(value= "get/{idUser}", produces = "application/json")
  public BaseResponseDto<StockDto> getStockInfo(@PathVariable("idUser") String idUser) throws IOException {
    BaseResponseDto<StockDto> response = new BaseResponseDto<>();

    Map<String, Map> test = stockService.getStock(idUser);
    response.setResponse(test);
    
    return response;
  }
}
