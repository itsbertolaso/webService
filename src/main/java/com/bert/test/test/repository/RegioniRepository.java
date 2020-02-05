package com.bert.test.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bert.test.test.dao.RegioniDao;

@Repository
public interface RegioniRepository  extends JpaRepository<RegioniDao, Long> {
	List<RegioniDao> findByIsoCountry(String iso_coun);
}