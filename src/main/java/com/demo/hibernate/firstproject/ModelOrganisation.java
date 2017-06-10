package com.demo.hibernate.firstproject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({@NamedQuery(name="org.getData", query="select org from ModelOrganisation org group by org")})
@Table(name="organisation")
@Entity
public class ModelOrganisation extends ModelBasic{
	
	public static final String GET_ORG_DATA = "org.getData";
	@Column(name="org_code", columnDefinition="varchar(25)")
	private String orgCode;
	
	@Column(name="org_name", columnDefinition="varchar(25)")
	private String orgName;
	
	@Column(name="org_strength", length=5)
	private int orgStrength;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="org_dpt", foreignKey = @ForeignKey(name="fk_org_dpt"), inverseForeignKey = @ForeignKey(name="fk_dpt_org"),
	joinColumns = @JoinColumn(name="org_id", referencedColumnName= "id"), inverseJoinColumns = @JoinColumn(name="dpt_id", referencedColumnName="id"))
	private Set<ModelDepartment> departments = new HashSet<ModelDepartment>();

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getOrgStrength() {
		return orgStrength;
	}

	public void setOrgStrength(int orgStrength) {
		this.orgStrength = orgStrength;
	}

	public Set<ModelDepartment> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<ModelDepartment> departments) {
		this.departments = departments;
	}
	
	
	
	
}
