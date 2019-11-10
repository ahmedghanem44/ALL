package com.nemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nemo.dao.ProductDao;
import com.nemo.model.Product;

@Service("ps")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	private ProductDao pro;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void newProduct(Product product) {
		pro.addProduct(product);
	}

	public void removeProduct(Product product) {
		pro.deleteProduct(product);
	}

	public void editProduct(Product product) {
//		pro.updateProduct(product);

	}

	public Product getProductById(int id) {
		return pro.getProductById(id);
	}

	public List<Product> getAllProducts() {
		return pro.listProducts();
	}

}
