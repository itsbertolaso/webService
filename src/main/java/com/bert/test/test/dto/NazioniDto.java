package com.bert.test.test.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NazioniDto {

	@Column(name = "iso")
	private String idNazione;
	
	@Column(name = "description")
	private String name;
}