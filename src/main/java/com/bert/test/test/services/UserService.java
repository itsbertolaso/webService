package com.bert.test.test.services;

import com.bert.test.test.dto.UserDto;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.json.JSONObject;

import java.io.IOException;

public interface UserService {
  public UserDto login(String name, String password) throws ParseException, JSONException, IOException;
}
