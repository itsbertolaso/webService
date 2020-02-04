package com.bert.test.test.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
public class CittaDto {
    @Column(name = "id_city")
    private Long idCity;

    @Column(name = "description")
    private String name;

    @Column(name = "id_prov")
    private String idProv;
}
