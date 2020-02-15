package com.bert.test.test.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import jdk.internal.cmm.SystemResourcePressureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.bert.test.test.dao.UserDao;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService{
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDto login(String nome, String password) throws JSONException {
    Optional<UserDao> dao = userRepository.findById(nome);
    UserDto dto = new UserDto();

    if(dao.isPresent()){
      if(password.equals(dao.get().getPassword())){
        dto.setName(dao.get().getName());
        dto.setRole(dao.get().getRole());
        String token = createJWT(dto);
        dto.setJwt(token);
        dto.setConfig(dao.get().getConfig());
      }
    }

    return dto;
  }

  private String createJWT(UserDto dto) {
	  LocalDateTime dateStart = LocalDateTime.now();
	  LocalDateTime dateStop = dateStart.plusHours(1);
	  Date date = Date.from( dateStop.atZone( ZoneId.systemDefault()).toInstant());
	  try {
		    Algorithm algorithm = Algorithm.HMAC256("supersecretword");
		    String token = JWT.create()
		    	  .withExpiresAt(date)
		        .withIssuer("auth0")
		        .withSubject(dto.getRole())
		        .sign(algorithm);
		    System.out.println("Token:" + token);
        return token;
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}

	  return null;
  }
}
