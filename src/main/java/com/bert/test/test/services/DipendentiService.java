package com.bert.test.test.services;

import java.util.List;
import java.util.Optional;

import com.bert.test.test.dao.DipendentiDao;

public interface DipendentiService {
	
	public List<DipendentiDao> selTutti();
	public Optional<DipendentiDao> selById(Long id);
	
}
