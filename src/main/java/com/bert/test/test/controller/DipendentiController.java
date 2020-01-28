package com.bert.test.test.controller;

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
import com.bert.test.test.services.DipendentiService;


@RestController
@RequestMapping(value = "api/city")
public class DipendentiController {	
	@Autowired
	DipendentiService dipSer;
	
	@GetMapping(produces = "application/json", value = "/all")
	public ResponseEntity<List<DipendentiDao>> allCity(){
		List<DipendentiDao> cities = dipSer.selTutti();
		return new ResponseEntity<List<DipendentiDao>>(cities, HttpStatus.OK);
	}
}
