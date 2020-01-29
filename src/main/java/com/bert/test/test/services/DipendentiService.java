package com.bert.test.test.services;

import java.util.List;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;

public interface DipendentiService {
	
	public List<DipendentiDao> selTutti();
	public DipendentiDto ok();
}
