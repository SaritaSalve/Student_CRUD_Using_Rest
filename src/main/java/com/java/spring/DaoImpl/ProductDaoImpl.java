package com.java.spring.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spring.Dao.ProductDao;
import com.java.spring.Entities.ProductInfo;
import com.java.spring.beans.ProductBean;
import com.java.spring.util.HibernateUtil;

@Repository
public class ProductDaoImpl implements ProductDao{
	static {
		System.out.println("Dao class loaded");
	}

	@Autowired
	SessionFactory sessionfactory;
	
	
	public String saveProductToDb(ProductInfo bean) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tr=null;
		try {
		session= sessionfactory.openSession();
		tr=session.beginTransaction();
		if(!bean.getProdName().equals("") || bean.getPrice()!=0.0 || bean.getQuantity()!=0) {
		session.save(bean);
		return "Product Saved successfully...";
		}else {
			return "Please enter the valid input....";
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem to save the product.......");
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return "Product saved.....";
	}

	public List<ProductInfo> getListOfProduct() {
		Session session=null;
		Transaction tr=null;
		try {
			session=sessionfactory.openSession();
			Criteria criteria=session.createCriteria(ProductInfo.class);
			List<ProductInfo> productList= criteria.list();
			return productList;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return null;
	}

	public ProductBean getProductbyId(int productId) {
		Session session=null;
		Transaction tr=null;
		try {
			session=sessionfactory.openSession();
			tr=session.beginTransaction();
			ProductInfo productInfo=session.get(ProductInfo.class, productId);
			
			ProductBean bean = new ProductBean();
			bean.setName(productInfo.getProdName());
			bean.setPrice(productInfo.getPrice());
			bean.setProductId(productInfo.getProductId());
			bean.setQuantity(productInfo.getQuantity());
			return bean;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return null;
	}

	public String saveUpdatedProduct(ProductInfo productEntity) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tr=null;
		try {
		session= sessionfactory.openSession();
		tr=session.beginTransaction();
		session.update(productEntity);
		return "Product Updated successfully...";
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem to save product.......");
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return "Product Updated.....";
	}

	public String deleteProduct(int productId) {
		Session session=null;
		Transaction tr=null;
		try {
			session=sessionfactory.openSession();
			tr=session.beginTransaction();
			ProductInfo productInfo=session.get(ProductInfo.class, productId);
			if(productInfo.getProductId()!=0) {
			session.delete(productInfo);
			return "Product deleted....";
			}else {
				return "Product is not available....";

			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanUpResources(session, tr);
		}
		return "Product deleted....";
	}
}
