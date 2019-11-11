package com.nemo.test;

import java.util.Iterator;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;


public class EmpClient {

	public static void main(String[] args) {
		
//		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("EmployeeSpringHibernate.cfg.xml");
//		BeanFactory bf=(BeanFactory)context;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeSpringHibernate.cfg.xml");
		BeanFactory factory = (BeanFactory) context;
		

		
		System.out.println("stooooop");
		
//		Resource res = new ClassPathResource("EmployeeSpringHibernate.cfg.xml");
//		BeanFactory factory = new XmlBeanFactory(res);
		
		Employee e1 = (Employee) factory.getBean("emp");
		e1.setEmpId(2);
		e1.setFname("Tom");
		e1.setLname("Hanks");
		Employee e2 = (Employee) factory.getBean("emp");
		e2.setEmpId(3);
		e2.setFname("Jack");
		e2.setLname("Nickelson");
		Employee e3 = (Employee) factory.getBean("emp");
		e3.setEmpId(4);
		e3.setFname("Robert");
		e3.setLname("DeNiro");
		
		
		
		EmployeeImp emp=(EmployeeImp) factory.getBean("dl");
		emp.storeToDb(e1);
		emp.storeToDb(e2);
		emp.storeToDb(e3);
		
		Iterator<Employee> itr = emp.getEmployeeNames();
		while(itr.hasNext()) {
			Employee e =  (Employee) itr.next();
			System.out.println(e.getEmpId()+". "+e.getFname()+" "+e.getLname());
		}
		

		
		
	}

}
