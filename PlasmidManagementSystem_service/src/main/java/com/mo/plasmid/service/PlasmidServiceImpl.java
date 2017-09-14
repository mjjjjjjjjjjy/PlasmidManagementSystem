package com.mo.plasmid.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.mo.plasmid.dao.PlasmidDao;
import com.mo.plasmid.dao.PlasmidDaoImpl;
import com.mo.plasmid.domain.PageBean;
import com.mo.plasmid.domain.Plasmid;

@Transactional
public class PlasmidServiceImpl implements PlasmidService {
	
	private PlasmidDao plasmidDao;
	public void setPlasmidDao(PlasmidDao plasmidDao) {
		this.plasmidDao = plasmidDao;
	}
	
	public void save(Plasmid plasmid) {
		plasmidDao.save(plasmid);
	}

	public List<Plasmid> fandAll() {
		List<Plasmid> findAll = plasmidDao.findAll();
		return findAll;
		
	}

	@Override
	public PageBean<Plasmid> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		return plasmidDao.findByPage(pageCode, pageSize, criteria);
		
	}

	@Override
	public Plasmid findById(Long p_id) {
		return plasmidDao.findById(p_id);
	}

	@Override
	public void delete(Plasmid plasmid) {
		plasmidDao.delete(plasmid);
		
	}

	//更新操作
	public void update(Plasmid plasmid) {
		plasmidDao.update(plasmid);
		
	}

}
