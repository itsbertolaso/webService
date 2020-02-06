package com.bert.test.test.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CittaDto {
    @Column(name = "id_city")
    private Long idCity;

    @Column(name = "description")
    private String name;

    @Column(name = "id_prov")
    private String idProv;

    @NotNull
    private ProvinceDto province;
}
