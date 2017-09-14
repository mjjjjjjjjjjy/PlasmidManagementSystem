package com.mo.plasmid.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.mo.plasmid.domain.Dict;
import com.mo.plasmid.domain.PageBean;
import com.mo.plasmid.domain.Plasmid;
import com.mo.plasmid.service.PlasmidService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlasmidAction extends BaseAction implements ModelDriven<Plasmid> {
	
	private static final long serialVersionUID = -230768583472318174L;

	public Plasmid plasmid = new Plasmid();
	public Plasmid getModel() {
		// TODO Auto-generated method stub
		return plasmid;
	}
	
	private PlasmidService plasmidService;
	public void setPlasmidService(PlasmidService plasmidService) {
		this.plasmidService = plasmidService;
	}
	public String update(){
		System.out.println("更新："+plasmid);
		plasmidService.update(plasmid);
		return "update";
	}
	public String initUpdate(){
		plasmid=plasmidService.findById(plasmid.getP_id());
		System.out.println("根据Id进行查询并返回一个Plasmid对象："+plasmid);
		return "initUpdate";
	}
	//根据p_id进行删除
	public String delete(){
		Plasmid plasmid2= new Plasmid();
		plasmid2=plasmidService.findById(plasmid.getP_id());
		System.out.println("即将删除："+plasmid2);
		plasmidService.delete(plasmid2);
		return "delete";
	}
	
	//分页查询
	public String findByPage(){
		System.out.println("进入到PlamidAction的findByPage方法");
		System.out.println(plasmid);
		DetachedCriteria criteria = DetachedCriteria.forClass(Plasmid.class);
		String p_plasmidNumber=plasmid.getP_plasmidNumber();
		if(p_plasmidNumber != null && !p_plasmidNumber.trim().isEmpty()){
			criteria.add(Restrictions.like("p_plasmidNumber", "%"+p_plasmidNumber+"%"));
		}
		String p_name=plasmid.getP_name();
		if(p_name != null && !p_name.trim().isEmpty()){
			criteria.add(Restrictions.like("p_name", "%"+p_name+"%"));
		}
		Dict constructor=plasmid.getConstructor();
		if(constructor != null && !constructor.getDict_id().trim().isEmpty()){
			criteria.add(Restrictions.like("constructor.dict_id", "%"+constructor.getDict_id()+"%"));
		}
		
		PageBean<Plasmid> pageBean=plasmidService.findByPage(criteria,getPageCode(),getPageSize());
		System.out.println("查询完成，准备压入值栈");
		System.out.println(pageBean);
		setVs("pageBean", pageBean);
		return "pageBean";
	}
	
	public String findAll(){
		List<Plasmid> findAll = plasmidService.fandAll();
		System.out.println(findAll);
		ActionContext.getContext().getValueStack().set("findAll", findAll);;
		return "findAll";
	}
	
	public String  save(){
		System.out.println(plasmid);
		plasmidService.save(plasmid);
		return SUCCESS;
	}

}
