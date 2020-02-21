package com.bert.test.test.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bert.test.test.dao.UserDao;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.exception.UserAlreadyExistsException;
import com.bert.test.test.exception.UserNotFoundException;
import com.bert.test.test.repository.UserRepository;

import net.minidev.json.JSONObject;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

//  @Override
//  public UserDto login(String nome, String password) throws JSONException, UserNotFoundException {
//    Optional<UserDao> dao = userRepository.findById(nome);
//    UserDto dto = new UserDto();
//
//    if(dao.isPresent()){
//      if(password.equals(dao.get().getPassword())){
//        dto.setName(dao.get().getName());
//        dto.setRole(dao.get().getRole());
//        String token = createJWT(dto);
//        dto.setJwt(token);
//        dto.setConfig(dao.get().getConfig());
//      }
//    }
//    else {
//      throw new UserNotFoundException();
//    }
//
//    return dto;
//  }

  	@Override
  	public void register(JSONObject data) throws UserAlreadyExistsException, UnsupportedEncodingException, NoSuchAlgorithmException {

  		Optional<UserDao> dao = userRepository.findById(data.getAsString("name"));

  		if(!dao.isPresent()) {
  			UserDao user = new UserDao();
  			String psw = data.getAsString("password");

  			byte[] bytesOfMessage = psw.getBytes("UTF-8");

  			MessageDigest md = MessageDigest.getInstance("MD5");
  			byte[] thedigest = md.digest(bytesOfMessage);
      
  			String hash = DatatypeConverter.printHexBinary(thedigest);

  			user.setName(data.getAsString("name"));
  			user.setPassword(hash);
  			user.setRole("user");
  			user.setConfig("{}");
  			userRepository.saveAndFlush(user);
  		}
  		else {
  			throw new UserAlreadyExistsException();
  		}
  	}

  	@Override
  	public boolean checkUser(String jwt) {
  		boolean check = decodeJWT(jwt);
  		return  check;
  	}

    @Override
  	public UserDto login(String nome, String password) throws JSONException, UnsupportedEncodingException, NoSuchAlgorithmException, UserNotFoundException {
  		Optional<UserDao> dao = userRepository.findById(nome);
  		UserDto dto = new UserDto();

  		if(dao.isPresent()){
  			byte[] bytesOfMessage = password.getBytes("UTF-8");

	    	MessageDigest md = MessageDigest.getInstance("MD5");
	    	byte[] thedigest = md.digest(bytesOfMessage);
  		String hash = DatatypeConverter.printHexBinary(thedigest);

  			if(dao.get().getPassword().equals(hash)) {
  				dto.setName(dao.get().getName());
  				dto.setRole(dao.get().getRole());
  				String token = createJWT(dto);
  				dto.setJwt(token);
  				dto.setConfig(dao.get().getConfig());
  			}
  		}
  		else {
  			throw new UserNotFoundException();
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
		} 
    	catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}

    	return null;
    }

	@SuppressWarnings("unused")
	private boolean decodeJWT(String jwt){
	    try {
	    	DecodedJWT decode = JWT.decode(jwt);
	    	return true;
	    } 
	    catch (JWTDecodeException e) {
	    	return false;
	    }
	}
}