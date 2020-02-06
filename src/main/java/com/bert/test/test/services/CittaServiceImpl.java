package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dto.CittaDto;
import com.bert.test.test.dto.ProvinceDto;
import com.bert.test.test.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService{

	@Autowired
	CittaRepository cittaRep;

	@Autowired
	ProvinceService provinceService;

	
	/**
	* Metodo utilizzato internamente per ritornare tutte i DAO delle citta
	* @return
	*/
	
	private List<CittaDao> selTuttiPrivate() {
		return cittaRep.findAll();
	}


    /**
    * Kappa
    * Ritorna la lista delle città di una provincia
    * Usa i DTO
    * @param id
    * @return
    */

	@Override
	public ArrayList<CittaDto> selByIdProv(String id){
	    List<CittaDao> dao = cittaRep.findByIdProv(id);
	    ArrayList<CittaDto> dto = new ArrayList<CittaDto>();
	
	    for(CittaDao d : dao){
	        CittaDto temp = new CittaDto();
	
	        temp.setIdProv(d.getIdProv());
	        temp.setName(d.getName());
	        temp.setIdCity(d.getIdCity());
	
	        dto.add(temp);
	    }
	
	    return dto;
	}


	/**
	* Ritorna la lista di città con il suo id e quello della provincia
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
 	* Ritorna una lista con tutte le città
 	* @return
 	*/
 	
	@Override
	public ArrayList<CittaDto> selTutti(){
		ArrayList<CittaDto> dto = new ArrayList<CittaDto>();
		List<CittaDao> dao = this.selTuttiPrivate();

		for(CittaDao d : dao){
			CittaDto temp = new CittaDto();
			ProvinceDto proDto = provinceService.selById(d.getIdProv());
			
			temp.setIdProv(proDto.getIdProvincia());
			temp.setName(d.getName());
			temp.setIdCity(d.getIdCity());
			temp.setProvince(proDto);

			dto.add(temp);
		}

		return dto;
	}

	
	/**
	* Ritorna una città tramite il suo id
	* @param id
	* @return
	*/
	
	@Override
	public CittaDto selById(Long id){
		Optional<CittaDao> dao = cittaRep.findById(id);
		CittaDto dto = new CittaDto();
		  
		dto.setIdProv(dao.get().getIdProv());
		dto.setName(dao.get().getName());
		dto.setIdCity(dao.get().getIdCity());
	
		return dto;
	}
}