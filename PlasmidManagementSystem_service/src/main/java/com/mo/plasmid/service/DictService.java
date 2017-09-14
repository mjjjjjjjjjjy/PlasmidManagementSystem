package com.mo.plasmid.service;

import java.util.List;

import com.mo.plasmid.domain.Dict;

public interface DictService {
	
	public List<Dict> findByCode(String dict_type_code);
	void save(Dict dict);

	List<Dict> findAll();

}
