package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bert.test.test.dao.DipendentiDao;

@Repository
public interface DipendentiRepository extends JpaRepository<DipendentiDao, String> {
	List<DipendentiDao> findAllByOrderBySurname();
	List<DipendentiDao> findByNameLike(String name);
	List<DipendentiDao> findBySurnameLike(String surname);
	List<DipendentiDao> findByTaxcodeLike(String name);
	
}