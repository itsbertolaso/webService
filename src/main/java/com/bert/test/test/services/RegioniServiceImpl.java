package com.bert.test.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.RegioniDao;
import com.bert.test.test.repository.RegioniRepository;

@Service
@Transactional
public class RegioniServiceImpl implements RegioniService {

	@Autowired
	RegioniRepository regioniRepository;
	
	@Override
	public List<RegioniDao> selTutti() {
		return regioniRepository.findAll();
	}
}