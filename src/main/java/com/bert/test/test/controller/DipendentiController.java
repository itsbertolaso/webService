package com.bert.test.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.DipendentiDto;
import com.bert.test.test.services.DipendentiService;

@RestController
@RequestMapping(value = "api/dipendenti")
public class DipendentiController {
	
	
	/**
	 * 
	 * Ultime modifiche: KAPPA
	 * N.B.: tutto le precedenti classi/metodi sono stati COMMENTATI e non 
	 * eliminati
	 * 
	 */
	
	
	private static final Logger logger = LoggerFactory.getLogger(DipendentiController.class);

	@Autowired
	DipendentiService dipendentiService;
	
	/**
	 * Funzione che usa SOLO i DTO.
	 */
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<ArrayList<DipendentiDto>> listAllDipendenti(){
		
		BaseResponseDto<ArrayList<DipendentiDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutti i dipendenti *******");
		
		ArrayList<DipendentiDto> dipendente = dipendentiService.selTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (dipendente.isEmpty()) {
			response.setResponse(null);
		}
		else {
			logger.info("Numero dei record: " + dipendente.size());
			response.setResponse(dipendente);
		}
		
		return response;		
	}
	
	/**
	 * Questa funzione va ad usare i DAO quando invece si può chiamare direttamente 
	 * il dto.
	 */
	
	/*@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> listAllDipendenti(){
		
		BaseResponseDto<List<DipendentiDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutti i dipendenti *******");
		
		List<DipendentiDao> dipendente = dipendentiService.selTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		if (dipendente.isEmpty()) {
			response.setResponse(null);
		}
		else {
			logger.info("Numero dei record: " + dipendente.size());
			
			//DipendentiDto dto = new DipendentiDto();
			//dto.setDipendentiData(dipendente);
			
			response.setResponse(dipendente);
		}
		
		return response;		
	}*/
  
	/**
	 * Routes di test -> esito positivo (DTO funzionante)
	 * @param idDipendente
	 * @return
	 */
	
	/*@GetMapping(produces = "application/json", value = "/test")
	public ResponseEntity<DipendentiDto> test(){
		DipendentiDto ciccio = dipendentiService.ok();
		return new ResponseEntity<DipendentiDto>(ciccio, HttpStatus.OK);
	}
	
	@GetMapping(produces = "application/json", value = "/cc")
	public ResponseEntity<ArrayList<DipendentiDto>> testCC(){
		ArrayList<DipendentiDto> ciccio = dipendentiService.cc();
		return new ResponseEntity<ArrayList<DipendentiDto>>(ciccio, HttpStatus.OK);
	}*/

	
	@GetMapping(value = "/id/{idDipendente}", produces = "application/json")
	public BaseResponseDto<DipendentiDao> listDipendentiById(@PathVariable("idDipendente") String idDipendente){
		
		BaseResponseDto<DipendentiDao> response = new BaseResponseDto<DipendentiDao>();
		logger.info("****** Cerca dipendente con id "+ idDipendente+" *******");

		Optional<DipendentiDao> dipendente = dipendentiService.selById(Long.parseLong(idDipendente));		
		DipendentiDao dip;
		
		try {
			dip = dipendente.get();
		}
		catch (NoSuchElementException ex) {
			dip = null;
		}
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		response.setResponse(dip);
	
		return response;
		
	}
	
	@GetMapping(value = "/delete/{idDipendente}", produces = "application/json")
	public BaseResponseDto<DipendentiDao> deleteDipendenteById(@PathVariable("idDipendente") String idDipendente){
		
		BaseResponseDto<DipendentiDao> response = new BaseResponseDto<DipendentiDao>();
		logger.info("****** Cancella dipendente con id "+ idDipendente+" *******");

		try {
			dipendentiService.deleteById(Long.parseLong(idDipendente));	
			response.setResponse("Deleted");
		}
		catch (EmptyResultDataAccessException ex) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		}
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		return response;
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	public BaseResponseDto<DipendentiDao> createDipendente(@RequestBody DipendentiDao dipendente) {
		
		BaseResponseDto<DipendentiDao> response = new BaseResponseDto<DipendentiDao>();
		logger.info("****** Crea dipendente " + dipendente.getName() + "******");
		
		dipendentiService.createDipendente(dipendente);
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		return response;
	}
	
	@PutMapping(value = "/update/{idDipendente}", produces = "application/json")
	public BaseResponseDto<DipendentiDao> updateDipendente(@RequestBody DipendentiDao dip, @PathVariable long idDipendente) {
		
		BaseResponseDto<DipendentiDao> response = new BaseResponseDto<DipendentiDao>();
		logger.info("****** Aggiorna dipendente " + idDipendente + "******");
		
		Optional<DipendentiDao> dipendente = dipendentiService.selById(idDipendente);
		
//		@SuppressWarnings("unused")
//		DipendentiDao temp;
		
		if(dipendente.isPresent()) {
			dip.setIdDipendente(""+idDipendente);
			dipendentiService.updateDipendente(dip);
		}
		else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		}
		
		/*
		 * Bisogna decidere se usare if/else o try/catch
		 */
	/*	
		try {
			temp = dipendente.get();
			dip.setIdDipendente(idDipendente);
			dipendentiService.updateDipendente(dip);
			response.setResponse("Updated");
		}
		catch (NoSuchElementException ex) {
			response.setResponse("Not found");
		}
	*/
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		return response;
	}
}