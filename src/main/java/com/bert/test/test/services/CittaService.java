package com.bert.test.test.services;

import java.util.List;
import java.util.Optional;

import com.bert.test.test.dao.CittaDao;

public interface CittaService {
	
	public List<CittaDao> selTutti();
	public Optional<CittaDao> selByIdCitta(Long id);
	public List<CittaDao> selByIdProv(String id);
	

}
