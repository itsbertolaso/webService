package com.bert.test.test.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "nazioni")
@Data
public class NazioniDao  implements Serializable
{
	private static final long serialVersionUID = -55;

	@Id
	@Column(name = "iso")
	private String iso;
	
	@Basic(optional = false)
	@Column(name = "description")
	private String description;
	
	

}
