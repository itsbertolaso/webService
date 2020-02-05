package com.bert.test.test.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "regioni")
@Data

public class RegioniDao {


	@Id
	@Column(name = "id_region")
	private Long idRegion;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "iso_coun")
	private String isoCountry;
}