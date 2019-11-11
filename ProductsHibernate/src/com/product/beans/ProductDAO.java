package com.product.beans;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.product.hibernateSession.SessionCreator;

public class ProductDAO{
	
	public static int addProduct(String name, String description, double price, int quantity) {
		Session ses  = (Session) SessionCreator.openProductSession();
		Transaction tr = ses.beginTransaction();
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		int id = (int) ses.save(product);
		tr.commit();
		ses.close();
//		System.out.println("Product ID number "+id+" has been added successfully");
		return id ;
	}

	public static void deleteProduct(int id) {
		Session ses  = (Session) SessionCreator.openProductSession();
		Transaction tr = ses.beginTransaction();
		Product product = new Product();
		product.setId(id);
		ses.delete(product);	
		tr.commit();
		ses.close();
//		System.out.println("Product ID number "+id+" has been deleted successfully");	
	}
	
	public static void updateProduct(int id,String name, String description, double price, int quantity) {
		Session ses  = (Session) SessionCreator.openProductSession();
		Transaction tr = ses.beginTransaction();
		Product product = new Product();
		product.setId(id);
		ses.update(product);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		tr.commit();
		ses.close();
//		System.out.println("Product ID number "+id+" has been deleted successfully");	
		
	}
	
	public static String getProductById(int ids) {
		Session ses  = (Session) SessionCreator.openProductSession();
		Transaction tr = ses.beginTransaction();
		Query query = ses.createQuery("from Product as pr where pr.id ="+ids);
		Product product = (Product) query.uniqueResult() ;
		tr.commit();
		ses.close();
		return product.toString();	
	}
	
	public static void listProduct() {
		Session ses  = (Session) SessionCreator.openProductSession();
		Transaction tr = ses.beginTransaction();
		Query query = ses.createQuery("from Product");
		List<Product> list = query.list();
		Iterator<Product> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		tr.commit();
		ses.close();
	}
	
	
}
