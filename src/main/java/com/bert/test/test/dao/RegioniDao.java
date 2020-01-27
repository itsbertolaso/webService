package com.bert.test.test.dao;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "regioni")
@Data
public class RegioniDao implements Serializable
{

	@Id
	@Column(name = "id_region")
	private String idRegion;
	
	@Basic(optional = false)
	@Column(name = "description")
	private String description;
	
	@Column(name = "iso_coun")
	private String isoCountry;

}
