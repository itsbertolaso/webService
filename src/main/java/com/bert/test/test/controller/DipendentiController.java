package com.bert.test.test.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.DipendentiDto;
import com.bert.test.test.services.DipendentiService;

import com.bert.test.test.controller.DipendentiController;

@RestController
@RequestMapping(value = "api/dipendenti")
public class DipendentiController {
	private static final Logger logger = LoggerFactory.getLogger(DipendentiController.class);

	@Autowired
	DipendentiService dipendentiService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<DipendentiDto>> listAllDipendenti()
	{
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
		
		
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		
		DipendentiDto dto = new DipendentiDto();
		dto.setDipendentiData(dipendente);
		
		response.setResponse(dto);
		return response;		
	}

}
