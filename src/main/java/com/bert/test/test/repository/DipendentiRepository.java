package com.bert.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.DipendentiDao;

public interface DipendentiRepository extends JpaRepository<DipendentiDao, Long> {}
