package com.bert.test.test.controller;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.services.UserService;

import net.minidev.json.JSONObject;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping(value = "api/login")
public class UserController {
  @Autowired
  UserService userService;

  /*@PostMapping(produces = "application/json")
  public BaseResponseDto<UserDto> login(@RequestBody JSONObject data) throws IOException, JSONException {

    BaseResponseDto<UserDto> response = new BaseResponseDto<>();

    String user = data.getAsString("name");
    String password = data.getAsString("password");

    UserDto dto = null;
    try {
      dto = userService.login(user, password);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    response.setResponse(dto);
    System.out.println("Da controller: " + response.getResponse());

    return response;
  }*/
  @PostMapping(produces = "application/json")
  public BaseResponseDto<UserDto> login(@RequestBody JSONObject data) throws IOException, JSONException {

    BaseResponseDto<UserDto> response = new BaseResponseDto<>();

    String user = data.getAsString("name");
    String password = data.getAsString("password");

    UserDto dto = null;
    try {
      dto = userService.login(user, password);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    response.setTimestamp(new Date());
    response.setStatus(HttpStatus.OK.value());
    response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
    response.setResponse(dto);

    return response;
  }
}
