package com.mo.plasmid.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plasmid {
	
	public Plasmid(){
		SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:ss");
		this.p_date=sdf_date.format(new Date());
		this.p_time=sdf_time.format(new Date());
	}
	private Long p_id;
	private String p_plasmidNumber;
	private String p_name;
//	private String p_vector;
//	private String p_constructor;
//	private String p_ruku;
	//字典
	private Dict vector;
	private Dict constructor;
	private Dict ruku;
	
	private String p_date;
	private String p_time;
	private String p_description;
	private String p_note;
	
	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public String getP_plasmidNumber() {
		return p_plasmidNumber;
	}

	public void setP_plasmidNumber(String p_plasmidNumber) {
		this.p_plasmidNumber = p_plasmidNumber;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Dict getVector() {
		return vector;
	}

	public void setVector(Dict vector) {
		this.vector = vector;
	}

	public Dict getConstructor() {
		return constructor;
	}

	public void setConstructor(Dict constructor) {
		this.constructor = constructor;
	}

	public Dict getRuku() {
		return ruku;
	}

	public void setRuku(Dict ruku) {
		this.ruku = ruku;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public String getP_time() {
		return p_time;
	}

	public void setP_time(String p_time) {
		this.p_time = p_time;
	}

	public String getP_description() {
		return p_description;
	}

	public void setP_description(String p_description) {
		this.p_description = p_description;
	}

	public String getP_note() {
		return p_note;
	}

	public void setP_note(String p_note) {
		this.p_note = p_note;
	}

	@Override
	public String toString() {
		return "Plasmid [p_id=" + p_id + ", p_plasmidNumber=" + p_plasmidNumber + ", p_name=" + p_name + ", vector="
				+ vector + ", constructor=" + constructor + ", ruku=" + ruku + ", p_date=" + p_date + ", p_time="
				+ p_time + ", p_description=" + p_description + ", p_note=" + p_note + "]";
	}
	
	
}
