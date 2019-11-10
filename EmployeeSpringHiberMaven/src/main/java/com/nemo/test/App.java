package com.nemo.test;

import java.util.Iterator;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeSpringHibernate.cfg.xml");
		BeanFactory factory = (BeanFactory) context;

//		Employee e1 = (Employee) factory.getBean("emp");
//		e1.setEmpId(2);
//		e1.setFname("Tom");
//		e1.setLname("Hanks");
//		Employee e2 = (Employee) factory.getBean("emp");
//		e2.setEmpId(3);
//		e2.setFname("Jack");
//		e2.setLname("Nickelson");
//		Employee e3 = (Employee) factory.getBean("emp");
//		e3.setEmpId(4);
//		e3.setFname("Robert");
//		e3.setLname("DeNiro");

		EmployeeImp emp=(EmployeeImp) factory.getBean("dl");
//		emp.storeToDb(e1);
//		emp.storeToDb(e2);
//		emp.storeToDb(e3);
		
		Iterator<Employee> itr = emp.getEmployeeNames();
		while(itr.hasNext()) {
			Employee e =  (Employee) itr.next();
			System.out.println(e.getEmpId()+". "+e.getFname()+" "+e.getLname());
		}
    }
}
