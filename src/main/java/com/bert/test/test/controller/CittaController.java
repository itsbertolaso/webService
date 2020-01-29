package com.bert.test.test.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.services.CittaService;

@RestController
@RequestMapping(value = "api/city")
public class CittaController {
	
	@Autowired
	CittaService cittaSer;
	
	@GetMapping(produces = "application/json", value = "/all")
	public ResponseEntity<List<CittaDao>> allCity(){
		List<CittaDao> cities = cittaSer.selTutti();
		return new ResponseEntity<List<CittaDao>>(cities, HttpStatus.OK);
	}
}
