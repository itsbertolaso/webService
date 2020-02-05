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

import com.bert.test.test.dto.BaseResponseDto;
import com.bert.test.test.dto.NazioniDto;
import com.bert.test.test.services.NazioniService;

@RestController
@RequestMapping(value = "api/nazioni")
public class NazioniController {
		
		@Autowired
		NazioniService nazioniService;

		@GetMapping(produces = "application/json")
		public BaseResponseDto<ArrayList<NazioniDto>> allNations(){

			ArrayList<NazioniDto> nazioni = nazioniService.selTutti();

			BaseResponseDto<ArrayList<NazioniDto>> res = new BaseResponseDto<ArrayList<NazioniDto>>();

			res.setTimestamp(new Date());
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
			res.setResponse(nazioni);

			return res;
		}

		@GetMapping(produces = "application/json", value = "/id/{idNazione}")
		public BaseResponseDto<List<NazioniDto>> findByNazioneId(@PathVariable("idNazione") String id){

			NazioniDto nazioni = nazioniService.selNazioneById(id);

			BaseResponseDto<List<NazioniDto>> res = new BaseResponseDto<List<NazioniDto>>();

			res.setTimestamp(new Date());
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
			res.setResponse(nazioni);

			return res;
		}
}