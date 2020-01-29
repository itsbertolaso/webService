package com.bert.test.test.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data
public class DipendentiDao {
	@Id
	@Column(name = "id")
	private Long idDipendente;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "tax_code")
	private String taxCode;

	@Basic(optional = false)
	@Column(name = "gender")
	private String gender;

	@Basic(optional = false)
	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "city", foreignKey = @ForeignKey(name = "dipendenti_ibfk_1"))
	private CittaDao city;

}
