package com.demo.hibernate.firstproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_address")
public class ModelEmployeeAddress extends ModelBasic{
	
	@Column(name="first_line", columnDefinition="varchar(25)")
	private String firstLine;
	
	@Column(name="second_line", columnDefinition="varchar(25)")
	private String secondLine;
	
	@Column(name="area_name", columnDefinition="varchar(25)")
	private String areaName;
	
	@Column(name="state", columnDefinition="varchar(25)")
	private String state;
	
	@Column(name="pincode", length=7)
	private int pincode;
	
	@Column(name="country", columnDefinition="varchar(25)")
	private String country;

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
