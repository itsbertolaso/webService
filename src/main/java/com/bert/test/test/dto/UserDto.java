package com.bert.test.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
  private int id;
  private String name;
  private String jwt; //da implementare in futuro
  private String role;
}
