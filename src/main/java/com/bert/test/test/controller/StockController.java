package com.bert.test.test.controller;

import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.StockDto;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.services.DipendentiService;
import com.bert.test.test.services.StockService;
import com.bert.test.test.services.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.io.*;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
