package com.nemo.dao;

import java.util.List;

import com.nemo.model.Product;

public interface ProductDaoInterface {
	
	void addProduct(Product product);
	void deleteProduct(Product product);
//	void updateProduct(Product product);
	Product getProductById(int id);
	List<Product> listProducts();

}
