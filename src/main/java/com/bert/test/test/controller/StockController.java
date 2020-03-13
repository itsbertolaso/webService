package com.bert.test.test.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public BaseResponseDto<StockDto> getTest(@PathVariable("idUser") String idUser){
    BaseResponseDto<StockDto> response = new BaseResponseDto<>();
    response.setResponse(stockService.getStock1(idUser));

    return response;
  }

  @PostMapping(value = "update", produces = "application/json")
  public BaseResponseDto<StockDto> updatePref(@RequestBody Map<String, Object> stock){
    BaseResponseDto<StockDto> response = new BaseResponseDto<>();


    for (Map.Entry<String, Object> entry : stock.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue().toString());
    }

    response.setResponse(stock);

    return response;
  }
}
