package com.bert.test.test.dao;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonObject;
import jdk.internal.instrumentation.TypeMapping;
import lombok.Data;
import net.minidev.json.JSONObject;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
