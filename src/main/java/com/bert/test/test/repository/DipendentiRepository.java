package com.bert.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bert.test.test.dao.DipendentiDao;

@Repository
public interface DipendentiRepository extends JpaRepository<DipendentiDao, String> {}