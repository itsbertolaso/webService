package com.bert.test.test.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "province")
@Data
public class ProvinceDao{
	@Id
	@Column(name = "id_prov")
	private String idProvincia;

	@Basic(optional = false)
	@Column(name = "description")
	private String description;
	
	@Column(name = "id_regione")
	private String idRegione;
	

}
