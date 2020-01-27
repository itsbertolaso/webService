package com.bert.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.CittaDao;

public interface NazioniRepository extends JpaRepository<CittaDao, String> {

}
