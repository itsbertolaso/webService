package com.bert.test.test.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

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
import com.bert.test.test.exception.UserAlreadyExistsException;
import com.bert.test.test.exception.UserNotFoundException;
import com.bert.test.test.services.UserService;

import net.minidev.json.JSONObject;

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
	public BaseResponseDto<UserDto> login(@RequestBody JSONObject data) throws IOException, JSONException, NoSuchAlgorithmException, ParseException {

		BaseResponseDto<UserDto> response = new BaseResponseDto<>();

		String user = data.getAsString("name");
		String password = data.getAsString("password");

		UserDto dto = null;
		try {
			dto = userService.login(user, password);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		}
    	catch (UserNotFoundException ex) {
    		response.setStatus(HttpStatus.NOT_FOUND.value());
    	}

		response.setTimestamp(new Date());
		response.setResponse(dto);

		return response;
	}

	@PostMapping(value="/register", produces = "application/json")
	public BaseResponseDto<UserDto> register(@RequestBody JSONObject data) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		BaseResponseDto<UserDto> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		try {
			userService.register(data);
			response.setStatus(HttpStatus.CREATED.value());
			response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		}
		catch (UserAlreadyExistsException ex) {
			response.setStatus(HttpStatus.CONFLICT.value());
		}

		return response;
	}
}
