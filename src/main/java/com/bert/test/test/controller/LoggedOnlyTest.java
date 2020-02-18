package com.bert.test.test.controller;

import com.bert.test.test.services.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping(value = "api/private")
public class LoggedOnlyTest {

  @Autowired
  UserService userService;

  @PostMapping
  @ExceptionHandler(MissingRequestHeaderException.class)
  public boolean ok(@RequestHeader(required = true, defaultValue = "null") String jwt){

    boolean check = userService.checkUser(jwt);
    if(check){
      return true;
    } else{
      return false;
    }

  }
}
