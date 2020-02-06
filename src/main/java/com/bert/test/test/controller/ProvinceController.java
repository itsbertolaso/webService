package com.bert.test.test.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bert.test.test.dto.ProvinceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.ProvinceDao;
import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.services.ProvinceService;


@RestController
@RequestMapping(value = "api/province")
public class ProvinceController {

	@Autowired
	ProvinceService provinceService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<ProvinceDao>> allCity(){

		List<ProvinceDao> province = provinceService.selTutti();

		BaseResponseDto<List<ProvinceDao>> res = new BaseResponseDto<List<ProvinceDao>>();

		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(province);

		return res;
	}

	@GetMapping(produces = "application/json", value = "/regione/{idRegione}")
	public BaseResponseDto<ArrayList<ProvinceDto>> findByIdRegione(@PathVariable("idRegione") String id){

    ArrayList<ProvinceDto> province = provinceService.selByIdRegione(id);
    
		BaseResponseDto<ArrayList<ProvinceDto>> res = new BaseResponseDto<ArrayList<ProvinceDto>>();

		res.setTimestamp(new Date());
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
		res.setResponse(province);

		return res;
	}
}
