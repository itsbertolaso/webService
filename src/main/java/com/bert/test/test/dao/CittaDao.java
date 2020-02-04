package com.bert.test.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "citta")
@Data
public class CittaDao {
	@Id
	@Column(name = "id_city")
	private Long idCity;
	
	@Column(name = "description")
	private String name;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "id_prov", referencedColumnName = "id_prov")
	@JsonBackReference 
	private ProvinceDao provincia;
}