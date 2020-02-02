package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;

public interface DipendentiService {
	
	/**
	 * 
	 * Ultime modifiche: KAPPA
	 * N.B.: tutto le precedenti classi/metodi sono stati COMMENTATI e non 
	 * eliminati
	 * 
	 */
	
	//public List<DipendentiDao> selTutti();
	public List<DipendentiDao> selTuttiPrivate();
	public ArrayList<DipendentiDto> selTutti();
	public Optional<DipendentiDao> selById(Long id);
	public void deleteById(Long id);
	public void createDipendente(DipendentiDao d);
	public void updateDipendente(DipendentiDao d);
}
