package com.bert.test.test.dto;

import java.util.Map;

import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {
  private String name;
  private String jwt;
  private String role;
  private Map<String, Object> config;

  public void setConfig(String config){
    JSONObject obj = new JSONObject(config);
    this.config = obj.toMap();
  }
}
