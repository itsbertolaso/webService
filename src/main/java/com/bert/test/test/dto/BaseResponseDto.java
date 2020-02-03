package com.bert.test.test.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * Ultime modifiche: KAPPA
 * 
 * Aggiunta di @getter e @setter
 * 
 * N.B.: tutto le precedenti classi/metodi sono stati COMMENTATI e non 
 * eliminati
 * 
 */


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponseDto<T>{
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private Object response;
	
}