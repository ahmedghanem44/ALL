package com.example.model;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.CoffeeType;
import com.beans.Coffee;
import com.session.CoffeeExpertSession;

public class CoffeeExpertDAO {
	
	Session ses = CoffeeExpertSession.openSession();
    Transaction tr = ses.beginTransaction();
	
	public void storeToDatabase() {
	    
		List<Coffee> cof = new ArrayList<Coffee>();
		cof.add(new Coffee("Latte"));
		cof.add(new Coffee("Cappucino"));
		CoffeeType cofType = new CoffeeType();
		cofType.setTypeName("Milky");
		cofType.setCoffee(cof);
		
		List<Coffee> cof2 = new ArrayList<Coffee>();
		cof2.add(new Coffee("Latte"));
		cof2.add(new Coffee("Cappucino"));
		cof2.add(new Coffee("Frappuccino"));
		CoffeeType cofType2 = new CoffeeType();
		cofType2.setTypeName("Froffy");
		cofType.setCoffee(cof2);
		
		List<Coffee> cof3 = new ArrayList<Coffee>();
		cof3.add(new Coffee("Frappuccino"));
		cof3.add(new Coffee("Ice Coffee"));
		CoffeeType cofType3 = new CoffeeType();
		cofType3.setTypeName("Icey");
		cofType3.setCoffee(cof3);
		
		List<Coffee> cof4 = new ArrayList<Coffee>();
		cof4.add(new Coffee("Espresso"));
		cof4.add(new Coffee("Double Espresso"));
		CoffeeType cofType4 = new CoffeeType();
		cofType4.setTypeName("Strong");
		cofType4.setCoffee(cof4);
		
		ses.persist(cofType);
		ses.persist(cofType2);
		ses.persist(cofType3);
		ses.persist(cofType4);
		
		tr.commit();
		
		System.out.println("added to db");
		
		ses.close();
   }
	
	
	  public List<String> getCoffeeList(String coffeType) {

		  Query query = ses.createQuery("from CoffeeType where typeName='"+coffeType+"'"); 
		  List<CoffeeType> cofType = query.getResultList() ; 
		  List<Coffee> list = cofType.get(0).getCoffee();
		  
		  List<String> coffeeNames = new ArrayList<String>() ; 
		  
		  Iterator<Coffee> itr = list.iterator(); 
		  while(itr.hasNext()) { 
			  String name = itr.next().getcName();
			  coffeeNames.add(name); 
			  } 
		  return coffeeNames;
	  
	  }
	 
}