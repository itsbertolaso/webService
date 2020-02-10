package com.bert.test.test.services;

import com.bert.test.test.dao.UserDao;
import com.bert.test.test.dto.UserDto;
import com.bert.test.test.repository.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
        //createJWT();
      }
    }

    return dto;
  }
}
