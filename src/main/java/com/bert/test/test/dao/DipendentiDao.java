package com.bert.test.test.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data
public class DipendentiDao 
{
	@Id
	@Column(name = "id")
	private String idDipendente;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "taxCode")
	private String taxCode;
	
	@Column(name = "gender")
	private String gender;
		
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private int city;
	
}
