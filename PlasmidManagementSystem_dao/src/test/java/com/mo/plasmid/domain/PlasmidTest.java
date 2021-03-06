package com.mo.plasmid.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mo.plasmid.dao.PlasmidDaoImpl;

public class PlasmidTest {

	@org.junit.Test
	public void testSave2(){
		
		Plasmid plasmid = new Plasmid();
		plasmid.setP_name("ly522");
//		plasmid.setP_vector("pet28");
		PlasmidDaoImpl plasmidDaoImpl = new PlasmidDaoImpl();
		plasmidDaoImpl.save(plasmid);
	}
	
	
	@org.junit.Test
	public void testSave(){
		Configuration config = new Configuration();
		// 默认加载src目录下的配置文件
		config.configure();
		// 创建SessionFactory对象
		SessionFactory factory = config.buildSessionFactory();
		// 创建session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		// 编写保存代码
		Plasmid plasmid = new Plasmid();
		plasmid.setP_name("ly5");
//		plasmid.setP_vector("pet28");
		// 保存客户
		session.save(plasmid);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
		factory.close();
	}
}
