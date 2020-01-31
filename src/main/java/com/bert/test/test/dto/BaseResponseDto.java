package com.bert.test.test.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponseDto<T> {
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private Object response;
}