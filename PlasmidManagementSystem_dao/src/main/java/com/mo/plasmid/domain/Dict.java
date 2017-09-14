package com.mo.plasmid.domain;

/**
 * 字典表
 */
public class Dict {
	
	private String dict_id;
	// 数据字典类别代码 001 002 003
	private String dict_type_code;
	// 类别名称 构建者 入库者 载体名称
	private String dict_type_name;
	// 字典 项目名称
	private String dict_item_name;
	
	public String getDict_id() {
		return dict_id;
	}
	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public String getDict_type_name() {
		return dict_type_name;
	}
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	public String getDict_item_name() {
		return dict_item_name;
	}
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	
	@Override
	public String toString() {
		return "Dict [dict_id=" + dict_id + ", dict_type_code=" + dict_type_code + ", dict_type_name=" + dict_type_name
				+ ", dict_item_name=" + dict_item_name + "]";
	}
	
	
}









