package com.bert.test.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.NazioniDao;
import com.bert.test.test.repository.NazioniRepository;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService{

	@Autowired
	NazioniRepository nazioniRepository;
	
	@Override
	public List<NazioniDao> selTutti() {
		return nazioniRepository.findAll();
	}

}
