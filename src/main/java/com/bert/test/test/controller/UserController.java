package com.bert.test.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.services.UserService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping(value = "api/login")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping(produces = "application/json")
  public BaseResponseDto<UserDto> login(@RequestBody JSONObject data){

    BaseResponseDto<UserDto> response = new BaseResponseDto<>();

    UserDto dto = userService.login(data);
    response.setResponse(dto);

    return response;
  }
}
