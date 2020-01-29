package com.bert.test.test.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;
import com.bert.test.test.repository.DipendentiRepository;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService{

	@Autowired
	DipendentiRepository dipSer;
	
	@Override
	public List<DipendentiDao> selTutti() {
		return dipSer.findAll();
	}
	
	@Override
	public DipendentiDto ok(){
		List<DipendentiDao> dao = this.selTutti();
		DipendentiDto dto = new DipendentiDto();
		
		dto.setIdDipendente(dao.get(0).getIdDipendente());
		dto.setName(dao.get(0).getName());
		dto.setSurname(dao.get(0).getSurname());
		dto.setTaxcode(dao.get(0).getTaxCode());
		
		return dto;
	}
	
	@Override
	public ArrayList<DipendentiDto> cc(){
		List<DipendentiDao> dao = this.selTutti();
		ArrayList<DipendentiDto> dto = new ArrayList<DipendentiDto>();
		
		for(DipendentiDao d : dao) {
			DipendentiDto temp = new DipendentiDto();
			temp.setName(dao.get(0).getName());
			temp.setSurname(dao.get(0).getSurname());
			temp.setIdDipendente(dao.get(0).getIdDipendente());
			temp.setTaxcode(dao.get(0).getTaxCode());
			
			dto.add(temp);
		}
		
		
		return dto;
	}
}
