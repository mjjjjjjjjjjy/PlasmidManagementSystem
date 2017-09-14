package com.mo.plasmid.dao;

import java.util.List;
import com.mo.plasmid.domain.Dict;

public class DictDaoImpl extends BaseDaoImpl<Dict> implements DictDao {
	/**
	 * 通过类别码进行查询
	 */
	public List<Dict> findByCode(String dict_type_code) {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?", dict_type_code);
	}
}
