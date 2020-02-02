package com.bert.test.test.services;

import java.util.List;

import com.bert.test.test.dao.ProvinceDao;

public interface ProvinceService {
	
	public List<ProvinceDao> selTutti();
	public List<ProvinceDao> selByIdRegione(String idRegione);

}
