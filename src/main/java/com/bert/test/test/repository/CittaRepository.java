package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bert.test.test.dao.CittaDao;

@Repository
public interface CittaRepository extends JpaRepository<CittaDao, Long> {

	List<CittaDao> findByIdProv(String id);
}