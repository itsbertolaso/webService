package com.bert.test.test.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
@Data
public class UserDao {
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;
}
