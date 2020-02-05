package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.RegioniDao;
import com.bert.test.test.dto.RegioniDto;
import com.bert.test.test.repository.RegioniRepository;

@Service
@Transactional
public class RegioniServiceImpl implements RegioniService {

	@Autowired
	RegioniRepository regioniRepository;
	
	private List<RegioniDao> selTuttiPrivate() {
		return regioniRepository.findAll();
	}

	@Override
	public ArrayList<RegioniDto> selTutti() {
		List<RegioniDao> dao = this.selTuttiPrivate();
		ArrayList<RegioniDto> dto = new ArrayList<>();
		
		for(RegioniDao d : dao) {
			RegioniDto temp = new RegioniDto();
			temp.setIdRegion(d.getIdRegion());
			temp.setName(d.getDescription());
			temp.setIsoCountry(d.getIsoCountry());
			dto.add(temp);
		}
		
		return dto;
	}

	@Override
	public RegioniDto selRegioneById(Long id) {
		Optional<RegioniDao> dao = regioniRepository.findById(id);
		RegioniDto dto = new RegioniDto();
		dto.setIdRegion(dao.get().getIdRegion());
		dto.setName(dao.get().getDescription());
		dto.setIsoCountry(dao.get().getIsoCountry());
		return dto;
	}
}