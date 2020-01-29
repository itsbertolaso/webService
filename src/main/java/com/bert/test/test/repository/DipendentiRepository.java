package com.bert.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;

public interface DipendentiRepository extends JpaRepository<DipendentiDao, Long> {

}
