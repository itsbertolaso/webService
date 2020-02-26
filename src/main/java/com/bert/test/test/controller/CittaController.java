package com.bert.test.test.controller;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.CittaDto;
import com.bert.test.test.services.CittaService;


@RestController
@RequestMapping(value = "api/citta")
public class CittaController {

	@Autowired
	CittaService cittaService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<ArrayList<CittaDto>> allCity(){

		ArrayList<CittaDto> cities = cittaService.selTutti();

		BaseResponseDto<ArrayList<CittaDto>> res = new BaseResponseDto<ArrayList<CittaDto>>();

		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(cities);

		return res;
	}

	@GetMapping(produces = "application/json", value = "/idProv/{idProvince}")
	public BaseResponseDto<ArrayList<CittaDto>> findByProvinceId(@PathVariable("idProvince") String id){

		ArrayList<CittaDto> citta = this.cittaService.selByIdProv(id);

		BaseResponseDto<ArrayList<CittaDto>> res = new BaseResponseDto<ArrayList<CittaDto>>();

		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(citta);

		return res;
	}
	
	
    
}