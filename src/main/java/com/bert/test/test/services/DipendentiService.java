package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;

public interface DipendentiService {
	
	public List<DipendentiDao> selTutti();
	public DipendentiDto ok();
	public ArrayList<DipendentiDto> cc();
	public Optional<DipendentiDao> selById(Long id);
	public void deleteById(Long id);
	public void createDipendente(DipendentiDao d);
	public void updateDipendente(DipendentiDao d);
}
