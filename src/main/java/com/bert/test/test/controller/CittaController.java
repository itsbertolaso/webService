package com.bert.test.test.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.services.CittaService;


@RestController
@RequestMapping(value = "api/citta")
public class CittaController {
	
	@Autowired
	CittaService cittaService;
	
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<CittaDao>> allCity(){
		
		List<CittaDao> cities = cittaService.selTutti();
		
		BaseResponseDto<List<CittaDao>> res = new BaseResponseDto<List<CittaDao>>();
		
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(cities);
	
		return res;
	}
	
	@GetMapping(produces = "application/json", value = "/province/{idProvince}")
	public BaseResponseDto<List<CittaDao>> findByProvinceId(@PathVariable("idProvince") String id){
		
		List<CittaDao> cities = cittaService.selByIdProv(id);
		
		BaseResponseDto<List<CittaDao>> res = new BaseResponseDto<List<CittaDao>>();
		
		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(cities);
		
		return res;
	}
}