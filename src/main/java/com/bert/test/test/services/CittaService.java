package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dto.CittaDto;

public interface CittaService {
	
	//public List<CittaDao> selTuttiPrivate();
	public Optional<CittaDao> selByIdCitta(Long id);
//	public List<CittaDao> selByIdProv(String id);
	public ArrayList<CittaDto> selTuttiIds();
	public ArrayList<CittaDto> selTutti();

}
