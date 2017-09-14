package com.mo.plasmid.dao;

import java.util.List;

import com.mo.plasmid.domain.Dict;

public interface DictDao extends BaseDao<Dict> {
	List<Dict> findByCode(String dict_type_code);

}
