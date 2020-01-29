package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bert.test.test.dao.DipendentiDao;
import com.bert.test.test.dto.DipendentiDto;

@Repository
public interface DipendentiRepository extends JpaRepository<DipendentiDao, String> {
}
