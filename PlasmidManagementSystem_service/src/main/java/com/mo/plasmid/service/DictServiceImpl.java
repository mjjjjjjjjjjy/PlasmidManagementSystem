package com.mo.plasmid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mo.plasmid.dao.DictDao;
import com.mo.plasmid.domain.Dict;

@Transactional
public class DictServiceImpl implements DictService {

	private DictDao dictDao;
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	public void save(Dict dict) {
		dictDao.save(dict);
	}

	public List<Dict> findAll() {
		
		return dictDao.findAll();
	}

	public List<Dict> findByCode(String dict_type_code) {
		return dictDao.findByCode(dict_type_code);
	}

}
