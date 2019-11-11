package com.nemo;

import java.util.*;

public class EmployeeImp implements EmployeeInterface {
	
	private List<Employee> empList;
	
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public void addToList(Employee e) {
		empList.add(e);
	}

	public void getEmployeeNames() {
		System.out.println("The List of Employee:");
		Iterator<Employee> itr = empList.iterator();
		while(itr.hasNext()) {
			Employee e =  itr.next();
			System.out.println(e.getEmpId()+". "+e.getFname()+" "+e.getLname());
		}

	}

}
