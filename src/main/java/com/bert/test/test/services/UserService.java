package com.bert.test.test.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.bert.test.test.dao.UserDao;
import com.bert.test.test.exception.UserNotFoundException;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.bert.test.test.dto.UserDto;

public interface UserService {
  public UserDto login(String name, String password) throws ParseException, JSONException, IOException, UserNotFoundException;
  public boolean checkUser(String jwt);
  public void register(UserDao d) throws UserNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException;
}
