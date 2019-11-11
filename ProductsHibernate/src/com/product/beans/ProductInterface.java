package com.product.beans;


public interface ProductInterface {
	
	public int addProduct(String name, String description, double price, int quantity);
	public void deleteProduct(int id);
	public void updateProduct(int id);
	public String getProductById(int id);
	public void listProduct();

}
