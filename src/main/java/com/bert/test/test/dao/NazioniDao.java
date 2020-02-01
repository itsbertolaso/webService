package com.bert.test.test.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "nazioni")
@Data
public class NazioniDao {
	@Id
	@Column(name = "iso")
	private String iso;
	
	@Basic(optional = false)
	@Column(name = "description")
	private String description;
	
	

}
