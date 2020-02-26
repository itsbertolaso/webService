package com.bert.test.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CittaDao {

	@Id
	@Column(name = "id_city")
	private Long idCity;

	@Column(name = "description")
	private String name;

	@Column(name = "id_prov")
	private String idProv;

	
  /*@ManyToOne
  @JoinColumn(name = "id_prov", foreignKey = @ForeignKey(name = "citta_ibfk_1"))
	private ProvinceDao province;*/
}
