package com.bert.test.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.services.DipendentiService;

@RestController
@RequestMapping(value = "api/dip")
public class DipendentiController {
	@Autowired
	DipendentiService dipSer;
	
	public ResponseEntity<List<DipendentiDao>> allCity(){
		List<DipendentiDao> dipendenti = dipSer.selTutti();
		return new ResponseEntity<List<DipendentiDao>>(dipendenti, HttpStatus.OK);
	}
}

