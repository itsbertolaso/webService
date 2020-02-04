package com.bert.test.test.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "regioni")
@Data

public class RegioniDao {


	@Id
	@Column(name = "id_region")
	private String idRegion;
	
	@Column(name = "description")
	private String description;
//	@Column(name = "iso_coun")
//	private String isoCountry;
	
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "iso_coun", referencedColumnName = "iso")
	@JsonBackReference 
	private NazioniDao nazione;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "regione", targetEntity=ProvinceDao.class)
	private List<ProvinceDao> province = new ArrayList<>();
}