package com.bert.test.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.RegioniDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.RegioniDto;
import com.bert.test.test.services.RegioniService;

@RestController
@RequestMapping(value = "api/regioni")
public class RegioniController {
	
	@Autowired
	RegioniService regioniService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<ArrayList<RegioniDto>> allNations(){

		ArrayList<RegioniDto> regioni = regioniService.selTutti();

		BaseResponseDto<ArrayList<RegioniDto>> res = new BaseResponseDto<ArrayList<RegioniDto>>();

		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(regioni);

		return res;
	}

	@GetMapping(produces = "application/json", value = "/id/{idRegion}")
	public BaseResponseDto<List<RegioniDto>> findByRegioneId(@PathVariable("idRegion") Long id){

		RegioniDto regione = regioniService.selRegioneById(id);

		BaseResponseDto<List<RegioniDto>> res = new BaseResponseDto<List<RegioniDto>>();

		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(regione);

		return res;
	}
	
	@GetMapping(produces = "application/json", value = "/nazione/{iso_coun}")
	public BaseResponseDto<List<RegioniDao>> findByIso(@PathVariable("iso_coun") String iso) {
		
		List<RegioniDao> regioni = regioniService.selByIdIso(iso);
		
		BaseResponseDto<List<RegioniDao>> res = new BaseResponseDto<List<RegioniDao>>();
		
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(regioni);
		
		return res;
	}
}
