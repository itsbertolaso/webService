package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.bert.test.test.dao.ProvinceDao;
import com.bert.test.test.dto.CittaDto;
import com.bert.test.test.dto.ProvinceDto;
import com.bert.test.test.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.repository.CittaRepository;

@Service
@Transactional
public class CittaServiceImpl implements CittaService{

	@Autowired
	CittaRepository cittaRep;

	@Autowired
  ProvinceService provinceService;

	private List<CittaDao> selTuttiPrivate() {
		return cittaRep.findAll();
	}

  /**
   * Kappa
   * Rimuovo il metodo che usa i DAO perchè è integrato nel
   * metodo che usa il DTO
   * @param id
   * @return
   */

	/*@Override
	public Optional<CittaDao> selByIdCitta(Long id) {
		// TODO Auto-generated method stub
		return cittaRep.findById(id);
	}*/

  /**
   * Kappa
   * Ritorna la lista delle città di una provincia
   * Usa i DTO
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

	@Override
	public  ArrayList<CittaDto> selTutti(){
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
