package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.CittaDto;
import com.bert.test.test.dto.DipendentiDto;
import com.bert.test.test.repository.DipendentiRepository;

@Service
@Transactional
public class DipendentiServiceImpl implements DipendentiService{


	/**
	 *
	 * Ultime modifiche: KAPPA
	 * OBJ: selTuttiPrivate() diventa effettivamente privata
	 * N.B.: tutti i precedenti classi/metodi sono stati COMMENTATI e non
	 * eliminati
	 *
	 */


	@Autowired
	DipendentiRepository dipendentiRepository;
	@Autowired
	CittaService cittaService;

	/*@Override
	public List<DipendentiDao> selTutti() {
		return dipendentiRepository.findAll();
	}*/

	private List<DipendentiDao> selTuttiPrivate(){
		return dipendentiRepository.findAllByOrderBySurname();
	}

	public Optional<DipendentiDao> selByIdPrivate(Long id) {
		return dipendentiRepository.findById("" + id);
	}

	@Override
	public void deleteById(Long id) {
		if(dipendentiRepository.existsById("" + id)) {
			dipendentiRepository.deleteById("" + id);
		}else {
			return ;
		}
	}

	@Override
	public void createDipendente(DipendentiDao d) {
		dipendentiRepository.saveAndFlush(d);
	}

	@Override
	public void updateDipendente(DipendentiDao d) {
		dipendentiRepository.save(d);
	}

	/**
	 * La funzione chiama il DAO e da quello costruisce il DTO
	 */

	@Override
	public DipendentiDto selById(Long id){
		Optional<DipendentiDao> dao = this.selByIdPrivate(id);
		DipendentiDto dto = new DipendentiDto();

		try {
			dto.setIdDipendente(dao.get().getIdDipendente());
			dto.setName(dao.get().getName());
			dto.setSurname(dao.get().getSurname());
			dto.setTaxcode(dao.get().getTaxcode());
			CittaDto citta = new CittaDto();
			citta.setIdCity(dao.get().getCity().getIdCity());
			citta.setName(dao.get().getCity().getName());
			citta.setIdProv(dao.get().getCity().getIdProv());
			dto.setCitta(citta);
		} catch (Exception e) {
			dto = null;
		}

		return dto;
	}

	/**
	 * La funzione chiama il DAO e da quello costruisce
	 * un ArrayList di DTO con solo i dati necessari
	 * @return ArrayList<DipendentiDto> dto
	 */
	@Override
	public ArrayList<DipendentiDto> selTutti(){
		List<DipendentiDao> dao = this.selTuttiPrivate();
		ArrayList<DipendentiDto> dto = new ArrayList<DipendentiDto>();

		for(DipendentiDao d : dao) {
			DipendentiDto temp = new DipendentiDto();

	        CittaDto cityDto = new CittaDto();
	        cityDto.setIdCity(d.getCity().getIdCity());
	        cityDto.setName(d.getCity().getName());
	        cityDto.setIdProv(d.getCity().getIdProv());

			temp.setName(d.getName());
			temp.setSurname(d.getSurname());
			temp.setIdDipendente(d.getIdDipendente());
			temp.setTaxcode(d.getTaxcode());
			temp.setCitta(cityDto);

			dto.add(temp);
		}

		return dto;
	}

	@Override
	public ArrayList<DipendentiDto> selByName(String name) {
		List<DipendentiDao> dao = dipendentiRepository.findByNameLike("%"+name+"%");
		
		ArrayList<DipendentiDto> dto = new ArrayList<DipendentiDto>();

		for(DipendentiDao d : dao) {
			DipendentiDto temp = new DipendentiDto();
	        CittaDto cityDto = new CittaDto();
	        cityDto.setIdCity(d.getCity().getIdCity());
	        cityDto.setName(d.getCity().getName());
	        cityDto.setIdProv(d.getCity().getIdProv());

			temp.setName(d.getName());
			temp.setSurname(d.getSurname());
			temp.setIdDipendente(d.getIdDipendente());
			temp.setTaxcode(d.getTaxcode());
			temp.setCitta(cityDto);

			dto.add(temp);
		}

		return dto;
	}

	@Override
	public ArrayList<DipendentiDto> selBySurname(String surname) {
		List<DipendentiDao> dao = dipendentiRepository.findBySurnameLike("%"+surname+"%");
		ArrayList<DipendentiDto> dto = new ArrayList<DipendentiDto>();

		for(DipendentiDao d : dao) {
			DipendentiDto temp = new DipendentiDto();
	        CittaDto cityDto = new CittaDto();
	        cityDto.setIdCity(d.getCity().getIdCity());
	        cityDto.setName(d.getCity().getName());
	        cityDto.setIdProv(d.getCity().getIdProv());

			temp.setName(d.getName());
			temp.setSurname(d.getSurname());
			temp.setIdDipendente(d.getIdDipendente());
			temp.setTaxcode(d.getTaxcode());
			temp.setCitta(cityDto);

			dto.add(temp);
		}

		return dto;
	}

	@Override
	public ArrayList<DipendentiDto> selByTaxcode(String taxcode) {
		List<DipendentiDao> dao = dipendentiRepository.findByTaxcodeLike("%"+taxcode+"%");
		ArrayList<DipendentiDto> dto = new ArrayList<DipendentiDto>();

		for(DipendentiDao d : dao) {
			DipendentiDto temp = new DipendentiDto();
	        CittaDto cityDto = new CittaDto();
	        cityDto.setIdCity(d.getCity().getIdCity());
	        cityDto.setName(d.getCity().getName());
	        cityDto.setIdProv(d.getCity().getIdProv());

			temp.setName(d.getName());
			temp.setSurname(d.getSurname());
			temp.setIdDipendente(d.getIdDipendente());
			temp.setTaxcode(d.getTaxcode());
			temp.setCitta(cityDto);

			dto.add(temp);
		}

		return dto;

	}

	@Override
	public DipendentiDao dipendenteDtoToDao(DipendentiDto dto) {
		
		Optional<DipendentiDao> daoOpt = this.selByIdPrivate(Long.parseLong(dto.getIdDipendente()));
		if(daoOpt.isPresent()) {
			DipendentiDao dao = daoOpt.get();
			dao.setCity(cittaDtoToDao(dto.getCitta()));
			dao.setName(dto.getName());
			dao.setSurname(dto.getSurname());
			dao.setTaxcode(dto.getTaxcode());
			return dao;
		}
		
		return null;	
	}
	
	private CittaDao cittaDtoToDao(CittaDto citta) {
		CittaDao dao = new CittaDao(citta.getIdCity(), citta.getName(), citta.getIdProv());
  		return dao;
  	}
}