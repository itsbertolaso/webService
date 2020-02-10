package com.bert.test.test.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.bert.test.test.dao.UserDao;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.repository.UserRepository;

import net.minidev.json.JSONObject;

@Service
@Transactional
public class UserServiceImpl implements UserService{
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDto login(JSONObject data) {
    System.out.println(data.getClass().getSimpleName());
    Optional<UserDao> dao = userRepository.findById(data.getAsString("name"));
    UserDto dto = new UserDto();

    if(dao.isPresent()){
      if(data.getAsString("password").equals(dao.get().getPassword())){
        dto.setName(dao.get().getName());
        dto.setRole(dao.get().getRole());
        createJWT(dto);
      }
    }

    return dto;
  }
  
  private String createJWT(UserDto dto) {
	  LocalDateTime dateStart = LocalDateTime.now();
	  LocalDateTime dateStop = dateStart.plusHours(1);
	  Date date = Date.from( dateStop.atZone( ZoneId.systemDefault()).toInstant());
	  try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    String token = JWT.create()
		    	.withExpiresAt(date)
		        .withIssuer("auth0")
		        .withSubject(dto.getRole())
		        .sign(algorithm);
		    System.out.println("Token:" + token);
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
	  
	  return null;
  }
}
