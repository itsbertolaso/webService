package com.bert.test.test.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonElement;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;


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
    for(String s : this.config.keySet()){
      System.out.println("Key: "+s+" Value: "+this.config.get((String) s));
    }
  }

  public Map<String, Object> getConfig(int i){
    System.out.println("MAPPA:" + config.isEmpty());
    for(String s : this.config.keySet()){
      System.out.println("Key: "+s+" Value: "+this.config.get((String) s));
    }
    return this.config;
  }
}
