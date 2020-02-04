package com.bert.test.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "nazioni")
@Data
public class NazioniDao {
	
	@Id
	@Column(name = "iso")
	private String iso;
	
	@Column(name = "description")
	private String description;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "nazione", targetEntity=RegioniDao.class)
	private List<RegioniDao> regioni = new ArrayList<>();
}