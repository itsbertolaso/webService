package com.bert.test.test.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegioniDto {

	@Column(name = "id_region")
	private Long idRegion;
	
	@Column(name = "description")
	private String name;
	
	@Column(name = "iso_coun")
	private String isoCountry;
}
