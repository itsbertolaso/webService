package com.bert.test.test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.repository.DipendentiRepository;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService{

	@Autowired
	DipendentiRepository dipSer;
	
	@Override
	public List<DipendentiDao> selTutti() {
		// TODO Auto-generated method stub
		return dipSer.findAll();
	}

}
