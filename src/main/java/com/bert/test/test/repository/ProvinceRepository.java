package com.bert.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bert.test.test.dao.ProvinceDao;

public interface ProvinceRepository  extends JpaRepository<ProvinceDao, Long> {

}
