package com.bert.test.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dao.DipendentiDao;
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
	
	/*@Override
	public List<DipendentiDao> selTutti() {
		return dipendentiRepository.findAll();
	}*/

	private List<DipendentiDao> selTuttiPrivate(){
		return dipendentiRepository.findAll();
	}

	public Optional<DipendentiDao> selByIdPrivate(Long id) {
		return dipendentiRepository.findById(""+id);
	}

	@Override
	public void deleteById(Long id) {
		dipendentiRepository.deleteById(""+id);
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
			temp.setName(d.getName());
			temp.setSurname(d.getSurname());
			temp.setIdDipendente(d.getIdDipendente());
			temp.setTaxcode(d.getTaxcode());
			
			dto.add(temp);
		}
		
		return dto;
	}
}
