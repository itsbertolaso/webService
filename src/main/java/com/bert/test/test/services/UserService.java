package com.bert.test.test.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONException;

import com.bert.test.test.dto.UserDto;
import com.bert.test.test.exception.UserAlreadyExistsException;
import com.bert.test.test.exception.UserNotFoundException;

import net.minidev.json.JSONObject;

public interface UserService {
  public UserDto login(String name, String password)throws JSONException, UnsupportedEncodingException, NoSuchAlgorithmException, UserNotFoundException;
  public boolean checkUser(String jwt);
  public void register(JSONObject data) throws UserAlreadyExistsException, UnsupportedEncodingException, NoSuchAlgorithmException;
  public UserDto getUser(String name);
  public String decodeJwt(String idUser);
}
