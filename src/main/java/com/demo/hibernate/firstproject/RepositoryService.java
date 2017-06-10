package com.demo.hibernate.firstproject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.firstproject.EnumEmployee.GENDER;

public class RepositoryService {
	public static void main(String[] args) {
		RepositoryService rs = new RepositoryService();
		Session session = rs.getSession();
		ModelEmployee me = rs.createModelEmployee();
		
		ModelEmployeeProfile mep = rs.createModelEmployeeProfile();
		
		ModelEmployeeAddress mea = rs.createModelEmployeeAddress();
		
		ModelDepartment md = rs.createDepartment();
		
		HashSet<ModelDepartment> departments = new HashSet<ModelDepartment>();
		departments.add(md);
		
		ModelOrganisation mo = rs.createModelOrganisation();
		
		mo.setDepartments(departments);
		
		
		List<ModelEmployeeAddress> addressList = new ArrayList<ModelEmployeeAddress>();
		addressList.add(mea);
		
		rs.persistData(session, mep);
		
		me.setProfile(mep);
		
		me.setAddress(addressList);
		
		me.setDepartment(md);
		
		rs.persistData(session, me);
		rs.persistData(session, mo);
		
		List<ModelEmployee> empList = rs.getEmployeeData(session);
		System.out.println(empList.get(0).getEmpName());
		
		
		List<ModelEmployeeProfile> empProfileList = rs.getEmployeeProfileData(session);
		System.out.println(empProfileList.get(0).getEmpQualification());
		
		
		System.out.println(empList.get(0).getAddress().get(0).getAreaName());
		System.out.println(empList.get(0).getDepartment().getDptSkill());
		
		List<ModelOrganisation> orgList = rs.getOrganisationData(session);
		System.out.println(orgList.get(0).getOrgCode()+"-"+orgList.get(0).getOrgName());
		
		mep.setEmpQualification("Master Degree");
		rs.updateData(session, mep);
		
		me.setProfile(mep);
		
		me.setEmpName("Hibernate-Java");
		rs.updateData(session, me);
		
		me.getAddress().get(0).setAreaName("area- name 2");
		
		me.getDepartment().setDptSkill("Non-Technical");
		
		mo.setOrgCode("IIT-D");
		mo.setOrgName("IIT-Delhi");
		rs.updateData(session, me);
		rs.updateData(session, mo);
		empList = rs.getEmployeeData(session);
		System.out.println(empList.get(0).getEmpName());
		
		
		empProfileList = rs.getEmployeeProfileData(session);
		System.out.println(empProfileList.get(0).getEmpQualification());
		
		System.out.println(empList.get(0).getAddress().get(0).getAreaName());
		
		System.out.println(empList.get(0).getDepartment().getDptSkill());
		orgList = rs.getOrganisationData(session);
		System.out.println(orgList.get(0).getOrgCode()+"-"+orgList.get(0).getOrgName());
		// rs.delete(session, me);
		
		System.out.println("Deleted employee instance with id and name"+me.getId() + " "+me.getEmpName());
		if(session != null) {
			session.close();
		}
	}

	private ModelOrganisation createModelOrganisation() {
		ModelOrganisation mo  = new ModelOrganisation();
		mo.setId("1");
		mo.setOrgCode("IIT-B");
		mo.setOrgName("IIT - Bombay");
		mo.setOrgStrength(4000);
		return mo;
	}

	private Session getSession() {
		SessionFactory sf = new Configuration().configure("hibernate.xml").buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

	private ModelEmployee createModelEmployee() {
		ModelEmployee me = new ModelEmployee();
		me.setId("1");
		me.setEmpName("Rajneesh");
		me.setEmpSalary(new BigDecimal(2000));
		return me;
	}
	
	private ModelEmployeeProfile createModelEmployeeProfile() {
		ModelEmployeeProfile mep = new ModelEmployeeProfile();
		mep.setId("1");
		mep.setEmpGender(GENDER.M);
		mep.setEmpQualification("Bachelor Degree");
		return mep;
	}
	
	private ModelEmployeeAddress createModelEmployeeAddress() {
		ModelEmployeeAddress mea = new ModelEmployeeAddress();
		mea.setId("1");
		mea.setFirstLine("first line");
		mea.setSecondLine("second line");
		mea.setAreaName("area name");
		mea.setState("state");
		mea.setCountry("country");
		mea.setPincode(11111);
		return mea;
	}
	
	private ModelDepartment createDepartment() {
		ModelDepartment md = new ModelDepartment();
		md.setId("1");
		md.setDptCode("001");
		md.setDptName("my deparment");
		md.setDptSkill("Technical");
		return md;
	}
	
	private void persistData(Session session, Object object) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(object);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Transaction Rolled Back due to :" + e);
		}
	}
	
	private void updateData(Session session, Object object) {
		Transaction tx = session.beginTransaction();
		try{
			session.update(object);
			tx.commit();
		}catch(Exception e) {
			System.out.println("Transaction Update rolled back due to: "+e);
		}
	}
	
	private List<ModelEmployee> getEmployeeData(Session session) {
		Query query = session.getNamedQuery(ModelEmployee.GET_EMPLOYEE_LIST);
		List<ModelEmployee> employeeList = query.getResultList();
		return employeeList;
	}
	
	private List<ModelOrganisation> getOrganisationData(Session session) {
		Query query = session.getNamedQuery(ModelOrganisation.GET_ORG_DATA);
		List<ModelOrganisation> orgList = query.getResultList();
		return orgList;
	}
	
	private List<ModelEmployeeProfile> getEmployeeProfileData(Session session) {
		Query query = session.getNamedQuery(ModelEmployeeProfile.GET_PROFILE);
		List<ModelEmployeeProfile> listProfile = query.getResultList();
		return listProfile;
 	}
	
	private void delete(Session session, Object object) {
		Transaction tx = session.beginTransaction();
		try{
			//ModelEmployee me = session.find(ModelEmployee.class, id);
			session.delete(object);
			tx.commit();
		} catch(Exception e) {
			System.out.println("Transaction delete rolled back due to:" +e);
		}
	}
}
