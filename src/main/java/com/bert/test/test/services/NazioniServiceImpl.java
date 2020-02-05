package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.NazioniDao;
import com.bert.test.test.dto.NazioniDto;
import com.bert.test.test.repository.NazioniRepository;

@Service
@Transactional
public class NazioniServiceImpl implements NazioniService{

	@Autowired
	NazioniRepository nazioniRepository;
	
	private List<NazioniDao> selAllPrivate() {
		return nazioniRepository.findAll();
	}
	
	@Override
	public ArrayList<NazioniDto> selTutti() {
		List<NazioniDao> dao = this.selAllPrivate();
		ArrayList<NazioniDto> dto = new ArrayList<>();
		
		for(NazioniDao d : dao) {
			NazioniDto temp = new NazioniDto();
			temp.setName(d.getDescription());
			temp.setIdNazione(d.getIso());
			dto.add(temp);
		}
		
		return dto;
	}

	@Override
	public NazioniDto selNazioneById(String id) {
		Optional<NazioniDao> dao = nazioniRepository.findById(id);
		NazioniDto dto = new NazioniDto();
		dto.setIdNazione(dao.get().getIso());
		dto.setName(dao.get().getDescription());
		return dto;
	}
}