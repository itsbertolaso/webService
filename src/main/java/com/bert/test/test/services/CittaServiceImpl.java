package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.bert.test.test.dto.CittaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService{

	@Autowired
	CittaRepository cittaRep;
	
	private List<CittaDao> selTuttiPrivate() {
		return cittaRep.findAll();
	}

	@Override
	public Optional<CittaDao> selByIdCitta(Long id) {
		// TODO Auto-generated method stub
		return cittaRep.findById(""+id);
	}

//	@Override
//	public List<CittaDao> selByIdProv(String id) {
//		// TODO Auto-generated method stub
//		return cittaRep.findByIdProv(id);
//	}

	/**
	 * Ritorna una lista di città con SOLO il nome
	 * @return
	 */

 	@Override
	public ArrayList<CittaDto> selTuttiIds(){
		List<CittaDao> dao = this.selTuttiPrivate();
		ArrayList<CittaDto> dto = new ArrayList<CittaDto>();

		for(CittaDao d : dao){
			CittaDto temp = new CittaDto();
			temp.setName(d.getName());
			dto.add(temp);
		}

		return dto;
	}

	/**
	 * Ritorna la lista di città con il suo id e quello della provincia
	 * @return
	 */

	@Override
	public  ArrayList<CittaDto> selTutti(){
		ArrayList<CittaDto> dto = new ArrayList<CittaDto>();
		List<CittaDao> dao = this.selTuttiPrivate();

		for(CittaDao d : dao){
			CittaDto temp = new CittaDto();
			temp.setName(d.getName());
			temp.setIdCity(d.getIdCity());
			temp.setProvincia(d.getProvincia().getDescription());
			
			dto.add(temp);
		}

		return dto;
	}
	
}
