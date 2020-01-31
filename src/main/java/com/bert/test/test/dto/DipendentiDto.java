package com.bert.test.test.dto;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.bert.test.test.dao.DipendentiDao;

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

}

