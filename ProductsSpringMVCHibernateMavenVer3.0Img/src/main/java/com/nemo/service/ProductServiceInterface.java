package com.nemo.service;

import java.util.List;

import com.nemo.model.Product;

public interface ProductServiceInterface {
	
	void newProduct(Product product);
	void removeProduct(Product product);
	void editProduct(Product product);
	Product getProductById(int id);
	List<Product> getAllProducts();
}
