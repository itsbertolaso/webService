package com.bert.test.test.services;

import java.util.ArrayList;

import com.bert.test.test.dto.NazioniDto;

public interface NazioniService {
	
	public ArrayList<NazioniDto> selTutti();
	public NazioniDto selNazioneById(String id);
}