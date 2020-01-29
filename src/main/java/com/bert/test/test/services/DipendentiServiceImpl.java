package com.bert.test.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.repository.DipendentiRepository;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService{
	
	@Autowired
	DipendentiRepository dipendentiRepository;
	
	@Override
	public List<DipendentiDao> selTutti() {
		return dipendentiRepository.findAll();
	}

	@Override
	public Optional<DipendentiDao> selById(Long id) {
		return dipendentiRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		dipendentiRepository.deleteById(id);
	}

	@Override
	public void createDipendente(DipendentiDao d) {
		dipendentiRepository.saveAndFlush(d);
	}
}