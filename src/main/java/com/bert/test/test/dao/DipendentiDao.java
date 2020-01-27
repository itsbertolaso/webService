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
	
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	
	@Basic(optional = false)
	@Column(name = "surname")
	private String surname;
	
	@Basic(optional = false)
	@Column(name = "taxCode")
	private String taxCode;
	
	@Basic(optional = false)
	@Column(name = "gender")
	private String gender;
		
	@Basic(optional = false)
	@Column(name = "address")
	private String address;
	
	@Basic(optional = false)
	@Column(name = "city")
	private int city;
	
}
