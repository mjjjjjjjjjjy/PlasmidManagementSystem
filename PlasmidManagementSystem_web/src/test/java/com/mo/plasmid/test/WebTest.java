package com.mo.plasmid.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.mo.plasmid.action.PlasmidAction;
import com.mo.plasmid.dao.PlasmidDao;
import com.mo.plasmid.domain.Plasmid;
import com.mo.plasmid.service.PlasmidService;

public class WebTest {
	
	@Test
	public void test() throws IOException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PlasmidAction plasmidAction = (PlasmidAction) context.getBean("plasmidAction"); 
//		Plasmid plasmid = new Plasmid();
		plasmidAction.plasmid.setP_name("test");
//		plasmid.setP_name("test");
		plasmidAction.save();
		
	}
	
	
	
	@Test
	public void TestFindAll()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PlasmidAction plasmidAction = (PlasmidAction) context.getBean("plasmidAction"); 
		String findAll = plasmidAction.findAll();
	}
	
	@Test
	public void TestDate(){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.println("当前时间：" + sdf.format(new Date()));
	}
	
	@Test
	public void TestWeb3() throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PlasmidAction plasmidAction = (PlasmidAction) context.getBean("plasmidAction"); 
		plasmidAction.save();
	}

	@Test
	public void TestWeb2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PlasmidService plasmidService = (PlasmidService) context.getBean("plasmidService"); 
		Plasmid plasmid  = new Plasmid();
		plasmid.setP_name("test daoapp");
		plasmidService.save(plasmid);
	}
	@Test
	public void TestWeb(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PlasmidDao plasmidDao = (PlasmidDao) context.getBean("plasmidDao"); 
		Plasmid plasmid  = new Plasmid();
		plasmid.setP_name("test daoapp");
		plasmidDao.save(plasmid);
	}
}
