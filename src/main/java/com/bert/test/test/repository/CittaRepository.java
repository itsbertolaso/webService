package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.CittaDao;
import com.bert.test.test.dao.ProvinceDao;

public interface CittaRepository extends JpaRepository<CittaDao, String> {

//	List<CittaDao> findByProvince(ProvinceDao provincia);
}