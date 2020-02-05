package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bert.test.test.dao.ProvinceDao;

@Repository
public interface ProvinceRepository  extends JpaRepository<ProvinceDao, String> {
	List<ProvinceDao> findByIdRegione(String idRegione);
}