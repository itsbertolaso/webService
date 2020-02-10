package com.bert.test.test.services;

import com.bert.test.test.dto.UserDto;
import net.minidev.json.JSONObject;

public interface UserService {
  public UserDto login(JSONObject data);
}
