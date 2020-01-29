package com.bert.test.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import lombok.Data;

@Entity
@Table(name = "citta")
@Data
public class CittaDao 
{
	@Id
	@Column(name = "id_city")
	private Long idCity;
	
	@Basic(optional = false)
	@Column(name = "description")
	private String name;
	
	@Column(name = "id_prov")
	private String idProv;
	
	
}
