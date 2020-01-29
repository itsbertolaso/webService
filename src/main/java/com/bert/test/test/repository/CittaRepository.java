package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.CittaDao;

public interface CittaRepository extends JpaRepository<CittaDao, Long> {

	List<CittaDao> findByIdProv(String id);
}