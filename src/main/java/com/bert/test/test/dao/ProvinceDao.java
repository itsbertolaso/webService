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
@Table(name = "province")
@Data
public class ProvinceDao {
	
	@Id
	@Column(name = "id_prov")
	private String idProvincia;

	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "id_region", referencedColumnName = "id_region")
	@JsonBackReference 
	private RegioniDao regione;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  mappedBy = "provincia", targetEntity=CittaDao.class)
	private List<CittaDao> citta = new ArrayList<>();
}