package com.bert.test.test.controller;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.DipendentiDto;
import com.bert.test.test.services.DipendentiService;

@RestController
@RequestMapping(value = "api/dipendenti")
public class DipendentiController {
	
	private static final Logger logger = LoggerFactory.getLogger(DipendentiController.class);

	@Autowired
	DipendentiService dipendentiService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> listAllDipendenti(){
		BaseResponseDto<List<DipendentiDto>> response = new BaseResponseDto<>();
		logger.info("****** Otteniamo tutte le promozioni *******");
		
		List<DipendentiDao> dipendente = dipendentiService.selTutti();
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		if (dipendente.isEmpty())
		{
			response.setResponse(null);
			return response;
		}
		
		logger.info("Numero dei record: " + dipendente.size());
		
		DipendentiDto dto = new DipendentiDto();
		dto.setDipendentiData(dipendente);
		
		response.setResponse(dto);
		return response;		
	}
	
	@GetMapping(value = "/id/{idDipendente}", produces = "application/json")
	public BaseResponseDto<DipendentiDao> listDipendentiById(@PathVariable("idDipendente") String idDipendente){
		BaseResponseDto<DipendentiDao> response = new BaseResponseDto<DipendentiDao>();
		logger.info("****** Cerca dipendete con id "+ idDipendente+" *******");

		Optional<DipendentiDao> dipendente = dipendentiService.selById(Long.parseLong(idDipendente));		
		DipendentiDao dip;
		try {
			dip = dipendente.get();
		}catch(NoSuchElementException e){
			dip = null;
		}
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		response.setResponse(dip);
	
		return response;
		
	}

}
