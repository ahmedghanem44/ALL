package com.nemo.test;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeImp implements EmployeeInterface {
	
//	private List<Employee> empList;
//	private Employees empAll;
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

//	public Employees getEmpAll() {
//		return empAll;
//	}
//
//	public void setEmpAll(Employees empAll) {
//		this.empAll = empAll;
//	}

	public Iterator getEmployeeNames() {
		Session ses = factory.openSession();
		Transaction tr = ses.beginTransaction();
		Query query = ses.createQuery("from Employee");
		List<Employee> list = query.list();
		System.out.println("The List of Employee:");
		Iterator<Employee> itr = list.iterator();
//		while(itr.hasNext()) {
//			Employee e =  itr.next();
//			System.out.println(e.getEmpId()+". "+e.getFname()+" "+e.getLname());
//		}
		return itr;

	}
	
	public void storeToDb(Employee e) {
		Session ses = factory.openSession();
		Transaction tr = ses.beginTransaction();
		Employee emp = new Employee();
		emp.setFname(e.getFname());
		emp.setLname(e.getLname());
		emp.setEmail(e.getEmail());
		
		ses.persist(emp);
		tr.commit();
		ses.close();
	}
		

//	public List<Employee> getEmpList() {
//		return empList;
//	}
//
//	public void setEmpList(List<Employee> empList) {
//		this.empList = empList;
//	}

//	public void addToList(Employee e) {
//		empList.add(e);
//	}

//	public void getEmployeeNames() {
//		System.out.println("The List of Employee:");
//		Iterator<Employee> itr = empList.iterator();
//		while(itr.hasNext()) {
//			Employee e =  itr.next();
//			System.out.println(e.getEmpId()+". "+e.getFname()+" "+e.getLname());
//		}

//	}

}
