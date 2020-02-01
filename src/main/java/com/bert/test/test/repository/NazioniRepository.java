package com.bert.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.NazioniDao;

public interface NazioniRepository extends JpaRepository<NazioniDao, String> {

}
