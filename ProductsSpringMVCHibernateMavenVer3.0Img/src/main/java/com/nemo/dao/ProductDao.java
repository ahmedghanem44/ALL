package com.nemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nemo.model.Product;

@Repository
public class ProductDao implements ProductDaoInterface {
	
	@Autowired
	private SessionFactory session;

	
	public void addProduct(Product product) {
		session.getCurrentSession().saveOrUpdate(product);
	}


	public void deleteProduct(Product product) {
//		session.getCurrentSession().delete(product);
		session.getCurrentSession().createQuery("Delete from Product where id="+product.getId()).executeUpdate();
	}


//	public void updateProduct(Product product) {
////		Product toUpdate = getProductById(product.getId());
//		session.getCurrentSession().createQuery("Update Product set name ='"+product.getName()+
//				"', price="+product.getPrice()+" , quantity="+product.getQuantity()+ " where id="+
//				product.getId());
////		toUpdate.setName(product.getName());
////		toUpdate.setPrice(product.getPrice());
////		toUpdate.setQuantity(product.getQuantity());
////		addProduct(toUpdate);
//	}

	
	public Product getProductById(int id) {
		return (Product) session.getCurrentSession().get(Product.class, id);	
	}

	
	public List<Product> listProducts() {
//		return (List<Product>) session.getCurrentSession().createQuery("from Product").list();
		return (List<Product>) session.getCurrentSession().createCriteria(Product.class).list();

	}

}
