package com.bert.test.test.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<CittaDao> selByIdCitta(Long id) {
		// TODO Auto-generated method stub
		return cittaRep.findById(""+id);
	}

	@Override
	public List<CittaDao> selByIdProv(String id) {
		// TODO Auto-generated method stub
		return cittaRep.findByIdProv(id);
	}
	
}
