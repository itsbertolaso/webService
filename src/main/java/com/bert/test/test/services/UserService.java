package com.bert.test.test.services;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.bert.test.test.dto.UserDto;

public interface UserService {
  public UserDto login(String name, String password) throws ParseException, JSONException, IOException;
  public boolean checkUser(String jwt);
}
