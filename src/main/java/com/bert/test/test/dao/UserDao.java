package com.bert.test.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

@Entity
@Table(name = "utente")
@Data
public class UserDao {
  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private String role;

  @Column(name = "config")
  private String config;

  public void setConfigStock(Map<String, Object> config){

    String test = config.get("stock").toString();

    String[] splitted = test.split(",");
    String[] formatted = new String[splitted.length];
    int k = 0;
    for(String s : splitted){
      s = s.replace("[", "");
      s = s.replace("]", "");
      s = s.replace(" ", "");
      formatted[k] = s;
      k++;
    }

    String temp = "";
    for(int i = 0; i <= formatted.length - 1; i++){
      temp += "," + '"' + formatted[i] + '"';
    }
    temp = temp.replaceFirst(",", "");

    String ok = "{"
      + '"' + "stock" + '"' + ":" + "[" + temp + "]" + ","
      + '"' + "type" + '"' + ":" + '"' + config.get("type") + '"' + ","
      + '"' + "registration" + '"' + ":" + '"' + config.get("registration") + '"'
      + "}";



    System.out.println("ok: " + ok);
    this.config = ok;

    /*String s = "{";
    for (Map.Entry<String, Object> entry : config.entrySet()) {
      System.out.println("ok: "+ entry.getKey());
      if(entry.getKey().equals("stock")){
        s+= "," + '"' + entry.getKey() + '"' + ":" + entry.getValue().toString();
      } else {

      }
      s+= "," + '"' + entry.getKey() + '"' + ":" + '"' + entry.getValue().toString() + '"';
    }
    s+="}";

    s = s.replaceFirst(",", "");
    System.out.println("stringa finita: " + s);
    this.config = s;*/
  }
}
