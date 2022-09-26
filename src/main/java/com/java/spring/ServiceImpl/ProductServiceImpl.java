package com.java.spring.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.Dao.ProductDao;
import com.java.spring.Entities.ProductInfo;
import com.java.spring.Service.ProductService;
import com.java.spring.beans.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {
	static {
		System.out.println("Service class loaded");
	}

	@Autowired
	ProductDao productDao;

	public String saveProduct(ProductBean bean) {

		return productDao.saveProductToDb(beanToEntity(bean));
	}

	public ProductInfo beanToEntity(ProductBean bean) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = new ProductInfo();
		productInfo.setPrice(bean.getPrice());
		productInfo.setProdName(bean.getName());
		productInfo.setProductId(bean.getProductId());
		productInfo.setQuantity(bean.getQuantity());
		return productInfo;
	}

	public List<ProductBean> getListOfProduct() {
		List<ProductInfo> productInfos = productDao.getListOfProduct();
		List<ProductBean> productList = listOfProductEntityToBean(productInfos);
		return productList;
	}

	private List<ProductBean> listOfProductEntityToBean(List<ProductInfo> productInfos) {
		List<ProductBean> beans = new ArrayList<ProductBean>();
		for (ProductInfo productInfo : productInfos) {
			ProductBean bean = new ProductBean();
			bean.setName(productInfo.getProdName());
			bean.setPrice(productInfo.getPrice());
			bean.setProductId(productInfo.getProductId());
			bean.setQuantity(productInfo.getQuantity());
			beans.add(bean);
		}
		return beans;
	}

	public ProductBean getProductbyId(int productId) {
		// TODO Auto-generated method stub
		return productDao.getProductbyId(productId);
	}

	public String saveUpdatedProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		return productDao.saveUpdatedProduct(beanToEntity(bean));
	}

	public String deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productId);
	}

}
