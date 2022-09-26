package com.java.spring.Dao;

import java.util.List;

import com.java.spring.Entities.ProductInfo;
import com.java.spring.beans.ProductBean;

public interface ProductDao {

	String saveProductToDb(ProductInfo productInfo);

	List<ProductInfo> getListOfProduct();

	ProductBean getProductbyId(int productId);

	String saveUpdatedProduct(ProductInfo beanToEntity);

	String deleteProduct(int productId);

}
