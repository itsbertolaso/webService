package com.bert.test.test.dto;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.bert.test.test.dao.DipendentiDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendentiDto {
	private List<DipendentiDao> dipendentiData;
}
