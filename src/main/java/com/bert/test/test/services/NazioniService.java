package com.bert.test.test.services;

import java.util.List;

import com.bert.test.test.dao.NazioniDao;

public interface NazioniService {
	
	public List<NazioniDao> selTutti();
	public NazioniDto selNazioneById(String id);
}