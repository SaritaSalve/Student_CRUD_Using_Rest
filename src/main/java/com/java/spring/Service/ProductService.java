package com.java.spring.Service;

import java.util.List;

import com.java.spring.beans.ProductBean;

public interface ProductService{

	String saveProduct(ProductBean bean);

	List<ProductBean> getListOfProduct();

	ProductBean getProductbyId(int productId);

	String saveUpdatedProduct(ProductBean bean);

	String deleteProduct(int productId);

}
