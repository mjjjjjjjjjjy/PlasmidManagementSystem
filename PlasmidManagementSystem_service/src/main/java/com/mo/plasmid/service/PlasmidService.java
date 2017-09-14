package com.mo.plasmid.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.mo.plasmid.domain.PageBean;
import com.mo.plasmid.domain.Plasmid;

public interface PlasmidService {
	public void save(Plasmid plasmid);

	public List<Plasmid> fandAll();

	public PageBean<Plasmid> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);

	public Plasmid findById(Long p_id);

	public void delete(Plasmid plasmid);

	public void update(Plasmid plasmid);
	
}
