package com.bert.test.test.services;

import java.util.ArrayList;

import com.bert.test.test.dto.CittaDto;

public interface CittaService {

	public ArrayList<CittaDto> selByIdProv(String id);
	public ArrayList<CittaDto> selTuttiIds();
	public ArrayList<CittaDto> selTutti();
	public CittaDto selById(Long id);
}