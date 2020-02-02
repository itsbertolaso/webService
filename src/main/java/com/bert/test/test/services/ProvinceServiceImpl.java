package com.bert.test.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.ProvinceDao;
import com.bert.test.test.repository.ProvinceRepository;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	ProvinceRepository provinceRepository;
	
	@Override
	public List<ProvinceDao> selTutti() {
		return provinceRepository.findAll();
	}

	@Override
	public List<ProvinceDao> selByIdRegione(String idRegione) {
		// TODO Auto-generated method stub
		return provinceRepository.findByIdRegione(idRegione);
	}
	
	
}