package com.bert.test.test.services;

import java.util.ArrayList;

import com.bert.test.test.dto.RegioniDto;

public interface RegioniService {
	
	public ArrayList<RegioniDto> selTutti();
	public RegioniDto selRegioneById(Long id);
}
