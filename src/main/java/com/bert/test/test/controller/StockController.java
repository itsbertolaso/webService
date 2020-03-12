package com.bert.test.test.controller;

import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.StockDto;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.services.DipendentiService;
import com.bert.test.test.services.UserService;
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
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/stock", produces = "application/json")
public class StockController {

  @Autowired
  UserService userService;

  @GetMapping(value= "get/{idUser}", produces = "application/json")
  public BaseResponseDto<StockDto> getStockInfo(@PathVariable("idUser") String idUser) throws IOException {
    BaseResponseDto<StockDto> response = new BaseResponseDto<>();

    UserDto user = userService.getUser(idUser);

    Map<String, Object> config = user.getConfig();

    //System.out.println(config.get("stock"));
    String stock = config.get("stock").toString();
    String[] stockSplit = stock.split(",");

    String api = "https://financialmodelingprep.com/api/v3/quote/";
    for(String s : stockSplit){
      s = s.replace("[", "");
      if(s.contains("]")){
        s = s.replace("]", "");
        api += s;
      } else{
        api += s + ",";
      }
    }

    api = api.replaceAll(" ", "");
    System.out.println("Stringa di connessione: " + api);

    InputStream is = new URL(api).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);

      String[] divided = jsonText.split("]");
      ArrayList<JSONObject> jsonOK = new ArrayList<>();

      for(String s : divided){
        s = s.replace("[", "");
        s = s.replace("]", "");
        System.out.println(s);
        JSONObject json = new JSONObject(s);
        jsonOK.add(json);
      }

      response.setResponse(jsonOK);
    } finally {
      is.close();
    }


    return response;
  }

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
}
