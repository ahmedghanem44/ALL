package com.nemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

public class EmpClient {

	public static void main(String[] args) {
		
		Resource res = new ClassPathResource("emp.cfg.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		
		Employee e1 = (Employee) bf.getBean("emp");
		e1.setEmpId(2);
		e1.setFname("Tom");
		e1.setLname("Hanks");
		Employee e2 = (Employee) bf.getBean("emp");
		e2.setEmpId(3);
		e2.setFname("Jack");
		e2.setLname("Nickelson");
		Employee e3 = (Employee) bf.getBean("emp");
		e3.setEmpId(4);
		e3.setFname("Robert");
		e3.setLname("DeNiro");
		
		
		EmployeeImp e = (EmployeeImp) bf.getBean("emps");
		e.addToList(e1);
		e.addToList(e2);
		e.addToList(e3);
		
		e.getEmployeeNames();
		
		
	}

}
