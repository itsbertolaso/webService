package com.bert.test.test.dao;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "citta")
@Data
public class CittaDao  implements Serializable
{
	@Id
	@Column(name = "id_city")
	private String idCity;
	
	@Basic(optional = false)
	@Column(name = "description")
	private String name;
	
	@Column(name = "id_prov")
	private String idProv;
	
}
