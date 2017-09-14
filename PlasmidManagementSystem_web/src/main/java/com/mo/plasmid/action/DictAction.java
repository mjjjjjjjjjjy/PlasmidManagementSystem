package com.mo.plasmid.action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mo.plasmid.domain.Dict;
import com.mo.plasmid.service.DictService;
import com.mo.plasmid.service.DictServiceImpl;
import com.mo.plasmid.utils.FastJsonUtil;
import com.opensymphony.xwork2.ModelDriven;

public class DictAction extends BaseAction implements ModelDriven<Dict> {

	private static final long serialVersionUID = 1086207550505121587L;
	
	private DictService dictService;
	public DictService getDictService() {
		return dictService;
	}
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	
	Dict dict = new Dict();
	public Dict getModel() {
		return dict;
	}
	
	public String save(){
		dictService.save(dict);
		System.out.println(dict);
		return SUCCESS;
	}
	public String  findAll(){
		List<Dict> list = dictService.findAll();
		System.out.println(list);
		setVs("findAll", list);
		return "findAll";
	}
	
	public String findByCode(){
		List<Dict> list = dictService.findByCode(dict.getDict_type_code());
		// 使用fastjson，把list转换成json字符串
		String jsonString = FastJsonUtil.toJSONString(list);
		// 把json字符串写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		// 输出
		FastJsonUtil.write_json(response, jsonString);
		System.out.println("DitAction的findByCode()方法已经完成");
		return NONE;
	}
	


}
