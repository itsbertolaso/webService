package com.bert.test.test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService{

	@Autowired
	CittaRepository cittaRep;
	
	@Override
	public List<CittaDao> selTutti() {
		return cittaRep.findAll();
	}
	
}
