package com.bert.test.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
