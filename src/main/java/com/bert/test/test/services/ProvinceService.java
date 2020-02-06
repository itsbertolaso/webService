package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;

import com.bert.test.test.dao.ProvinceDao;
import com.bert.test.test.dto.ProvinceDto;

public interface ProvinceService {

	public List<ProvinceDao> selTutti();
	//public List<ProvinceDao> selByIdRegione(String idRegione);
  public ProvinceDto selById(String id);
  ArrayList<ProvinceDto> selByIdRegione(String id);
}
