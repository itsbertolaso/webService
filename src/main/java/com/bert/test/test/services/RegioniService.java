package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;

import com.bert.test.test.dao.RegioniDao;
import com.bert.test.test.dto.RegioniDto;

public interface RegioniService {
	
	public ArrayList<RegioniDto> selTutti();
	public RegioniDto selRegioneById(Long id);
	public List<RegioniDao> selByIdIso(String iso_coun);
}
