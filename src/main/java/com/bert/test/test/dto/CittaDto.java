package com.bert.test.test.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
public class CittaDto {

    private Long idCity;


    private String name;


    private String provincia;
    
    
}
