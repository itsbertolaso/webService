package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bert.test.test.dto.ProvinceDto;
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
  public ArrayList<ProvinceDto> selByIdRegione(String id) {
    List<ProvinceDao> dao = provinceRepository.findByIdRegione(id);
    ArrayList<ProvinceDto> dto = new ArrayList<ProvinceDto>();

    for(ProvinceDao d : dao){
      ProvinceDto temp = new ProvinceDto();
      temp.setDescription(d.getDescription());
      temp.setIdRegione(d.getIdRegione());
      temp.setIdProvincia(d.getIdProvincia());
    }

    return dto;
  }

  @Override
	public ProvinceDto selById(String idRegione) {
		Optional<ProvinceDao> dao = provinceRepository.findById(idRegione);
		ProvinceDto dto = new ProvinceDto();
		dto.setIdProvincia(dao.get().getIdProvincia());
		dto.setIdRegione(dao.get().getIdRegione());
		dto.setDescription(dao.get().getDescription());

		return dto;
	}


}
