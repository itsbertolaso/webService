package com.bert.test.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bert.test.test.dto.CittaDto;

import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data
public class DipendentiDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String idDipendente;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "taxcode")
	private String taxcode;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "city", foreignKey = @ForeignKey(name = "dipendenti_ibfk_1"))
	private CittaDao city;
}