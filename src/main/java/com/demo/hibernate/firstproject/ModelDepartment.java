package com.demo.hibernate.firstproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class ModelDepartment extends ModelBasic{
	
	@Column(name="dpt_code", columnDefinition="varchar(25)")
	private String dptCode;
	
	@Column(name="dpt_name", columnDefinition="varchar(25)")
	private String dptName;
	
	@Column(name="dpt_skill", columnDefinition="varchar(25)")
	private String dptSkill;

	public String getDptCode() {
		return dptCode;
	}

	public void setDptCode(String dptCode) {
		this.dptCode = dptCode;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getDptSkill() {
		return dptSkill;
	}

	public void setDptSkill(String dptSkill) {
		this.dptSkill = dptSkill;
	}
	
	
}
