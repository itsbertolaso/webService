package com.bert.test.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "citta")
@Data
public class CittaDao {
	@Id
	@Column(name = "id_city")
	private Long idCity;

	@Column(name = "description")
	private String name;

	@Column(name = "id_prov")
	private String idProv;
}
