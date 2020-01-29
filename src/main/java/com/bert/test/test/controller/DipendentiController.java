package com.bert.test.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;
import com.bert.test.test.services.DipendentiService;

@RestController
@RequestMapping(value = "api/dip")
public class DipendentiController {
	@Autowired
	DipendentiService dipSer;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<DipendentiDao>> allDip(){
		List<DipendentiDao> dipendenti = dipSer.selTutti();
		if(dipendenti.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		
		return new ResponseEntity<List<DipendentiDao>>(dipendenti, HttpStatus.OK);	
	}
	
	@GetMapping(produces = "application/json", value = "/test")
	public ResponseEntity<DipendentiDto> test(){
		DipendentiDto ciccio = dipSer.ok();
		return new ResponseEntity<DipendentiDto>(ciccio, HttpStatus.OK);
	}
}

