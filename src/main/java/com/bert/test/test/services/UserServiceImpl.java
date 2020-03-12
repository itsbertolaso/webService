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


  /**
   * Questa funzione è a uso esclusivo del controller Stock per ottenere info dall' utente
   * Non toccare questa funzione fino a nuovo ordine.
   * @param name
   * @return
   */
  @Override
  public UserDto getUser(String name) {
    Optional<UserDao> dao = userRepository.findById(name);
    UserDto dto = new UserDto();

    System.out.println("DAO: " + dao);

    if(dao.isPresent()){
      dto.setJwt(null);
      dto.setRole(null);
      dto.setName(name);
      dto.setConfig(dao.get().getConfig());
    }

    return dto;
  }

  @Override
  	public boolean checkUser(String jwt) {
  		boolean check = decodeJWT(jwt);
  		return  check;
  	}

    @Override
  	public String decodeJwt(String jwt){
      DecodedJWT kk = JWT.decode(jwt);
      String nome = kk.getPayload();
      System.out.println("PAYLOAD: " + nome);
      return nome;
      //String name = JWT.parser().setSigningKey("supersecretword").parseClaimsJws("base64EncodedJwtHere").getBody().get("name", String.class);
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

  		  System.out.println("HASH: " + hash);
  		  System.out.println("PASSWORD: " + dao.get().getPassword());

  			if(dao.get().getPassword().toUpperCase().equals(hash)) {
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
	    		.withClaim("role", dto.getRole())
          .withClaim("nome", dto.getName())
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
