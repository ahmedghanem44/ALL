package com.nemo.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nemo.beans.ProductBean;
import com.nemo.model.Product;

@Component
public class BeanModelConverstion {
	
	@Autowired
	private ProductBean bean ;
	
	private Product product ;
	
	public ProductBean getBean() {
		return bean;
	}
	public void setBean(ProductBean bean) {
		this.bean = bean;
	}
	
	public Product convertToModel(ProductBean bean) {
		product = new Product();
		product.setId(bean.getId());
		product.setName(bean.getName());
		product.setPrice(bean.getPrice());
		product.setQuantity(bean.getQuantity());
		product.setImage(bean.getFileData().getBytes());
		return product;
	}
	
	public ProductBean convertToBean(Product product) {
		bean.setId(product.getId());
		bean.setName(product.getName());
		bean.setPrice(product.getPrice());
		bean.setQuantity(product.getQuantity());
		return bean;
	}
	
	public List<ProductBean> beanList(List<Product> products){
		List<ProductBean> beans = null;
		if(products != null && !products.isEmpty()){
			beans = new ArrayList<ProductBean>();
			ProductBean bean = null;
			for(Product product : products){
				bean = new ProductBean();
				bean.setName(product.getName());
				bean.setId(product.getId());
				bean.setPrice(product.getPrice());
				bean.setQuantity(product.getQuantity());;
				beans.add(bean);
			}
		}
		return beans;
	}

}
