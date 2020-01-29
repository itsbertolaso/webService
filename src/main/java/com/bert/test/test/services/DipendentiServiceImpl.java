package com.bert.test.test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bert.test.test.dao.DipendentiDao;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService{

	@Override
	public List<DipendentiDao> selTutti() {
		// TODO Auto-generated method stub
		return null;
	}

}
