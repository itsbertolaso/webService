package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.Optional;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;

public interface DipendentiService {
	
	/**
	 * 
	 * Ultime modifiche: KAPPA
	 * Modifiche: selTuttiPrivate viene rimosso dall' interfaccia
	 * N.B.: tutto le precedenti classi/metodi sono stati COMMENTATI e non 
	 * eliminati
	 * 
	 */

	public Optional<DipendentiDao> selByIdPrivate(Long id);
	public DipendentiDto selById(Long id);
	public ArrayList<DipendentiDto> selTutti();
	public void deleteById(Long id);
	public void createDipendente(DipendentiDao d);
	public void updateDipendente(DipendentiDao d);
}