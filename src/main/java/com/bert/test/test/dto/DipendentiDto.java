package com.bert.test.test.dto;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DipendentiDto {
	
	@NotNull
	private String idDipendente;

	@NotNull
	private String name;

	@NotNull
	private String surname;

	@NotNull
	private String taxcode;

	@NotNull
	private CittaDto citta;
	
	
}