package com.java.spring.Controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.Service.ProductService;
import com.java.spring.beans.ProductBean;

@Controller
public class ProductController {
	
	@Autowired 
	ProductService productService;
	
	static {
		System.out.println("Controller class loaded");
	}
	
	@RequestMapping(value="/add_new_product", method = RequestMethod.GET)
	public ModelAndView addNewProduct() {
		HashMap<String, Object> model=new HashMap<String, Object>();
		model.put("prodBean", new ProductBean());
		return new ModelAndView("add_product",model);
	}
	
	@RequestMapping(value="/save_product", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("productBean") ProductBean bean) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		String msg="";
//		if(bean.getProductId()!=0) {
//			msg= productService.saveUpdatedProduct(bean);
//			new ModelAndView("redirect:/show_product_list");
//		}else{
			msg= productService.saveProduct(bean);
			
//		}
	
		System.out.println(msg);
		model.put("prodBean", new ProductBean());
		model.put("msg", msg);
		return new ModelAndView("add_product",model);
		
	}

	@RequestMapping(value = "/show_product_list", method = RequestMethod.GET)
	public ModelAndView showProductList() {
		HashMap<String, Object> model=new HashMap<String, Object>();
		List<ProductBean> beans= productService.getListOfProduct();
		System.out.println("------------- "+beans);
		model.put("productList",  beans);
		return new ModelAndView("show_product",model);
	}
	
	@RequestMapping(value="/edit_product/{productId}", method = RequestMethod.GET)
	public ModelAndView updateProduct(@PathVariable("productId") int productId) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		ProductBean productBean=productService.getProductbyId(productId);
		System.out.println("Id to update ---- "+productId);
		model.put("prodBean", productBean);
		return new ModelAndView("add_product",model);
	}
	
	@RequestMapping(value="/update_product_Details/{productId}", method = RequestMethod.GET)
	public ModelAndView updateProductDetails(@PathVariable("productId") int productId) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		ProductBean productBean=productService.getProductbyId(productId);
		System.out.println("Id to update ---- "+productBean);
		
		model.put("prodBean", productBean);
		return new ModelAndView("add_product",model);
	}
	
	@RequestMapping(value="/save_updated_product", method = RequestMethod.POST)
	public ModelAndView updatedProduct(@ModelAttribute("productBean") ProductBean bean) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		String msg="";
		msg= productService.saveUpdatedProduct(bean);
		List<ProductBean> beans= productService.getListOfProduct();

		System.out.println(msg);
		model.put("msg", msg);
		model.put("productList",  beans);
		return new ModelAndView("show_product",model);
}
	@RequestMapping(value="/delete_product/{productId}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("productId") int productId) {
		HashMap<String, Object> model=new HashMap<String, Object>();
		String msg="";
		msg= productService.deleteProduct(productId);
		List<ProductBean> beans= productService.getListOfProduct();

		System.out.println(msg);
		model.put("msg", msg);
		model.put("productList",  beans);
		return new ModelAndView("show_product",model);
}
}
