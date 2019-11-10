package com.nemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nemo.beans.ProductBean;
import com.nemo.model.Product;
import com.nemo.operation.BeanModelConverstion;
import com.nemo.service.ProductService;
import com.nemo.service.ProductServiceInterface;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceInterface ps;
	@Autowired
	private BeanModelConverstion bmc;
	
	@RequestMapping(value ="/list" , method= RequestMethod.GET)
	public ModelAndView list() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",bmc.beanList(ps.getAllProducts()));
		return new ModelAndView("productsList", model); 
	}
	
	@RequestMapping(value="/new" , method= RequestMethod.GET)
	public ModelAndView newEntry(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
//	public ModelAndView newEntry() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",bmc.beanList(ps.getAllProducts()));
//		model.put("product",null);
		return new ModelAndView ("addProduct",model);
	}
	
	@RequestMapping(value="/save" , method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
		Product product = bmc.convertToModel(productBean);
		ps.newProduct(product);
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("products",ps.getAllProducts());
//		model.put("product",null);
		return new ModelAndView ("redirect:/new.html");
	}
	
	@RequestMapping(value="/edit" , method= RequestMethod.GET	)
	public ModelAndView edit(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
		ProductBean productBeanBeforeEdit = bmc.convertToBean(ps.getProductById(productBean.getId()));
//		ps.editProduct(bmc.convertToModel(productBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",bmc.beanList(ps.getAllProducts()));
		model.put("product",productBeanBeforeEdit);
		return new ModelAndView ("addProduct",model);
	}
	@RequestMapping(value="/delete" , method= RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
//		ProductBean bean = bmc.convertToBean(ps.getProductById(productBean.getId()));
		Product productToDelete = ps.getProductById(productBean.getId());
		ps.removeProduct(productToDelete);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",bmc.beanList(ps.getAllProducts()));
		model.put("product",null);
		return new ModelAndView ("redirect:/new.html",model);
	}
	
    @RequestMapping(value ="/productImage", method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("id") Integer id) throws IOException {
        Product product = null;
        if (id > 0) {
            product = ps.getProductById(id);
        }
        if (product != null && product.getImage() != null) { 
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }
	
}
