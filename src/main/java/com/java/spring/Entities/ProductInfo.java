package com.java.spring.Entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_INFO")
public class ProductInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String prodName;
	private double price;
	private int quantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", prodName=" + prodName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	public ProductInfo(int productId, String prodName, double price, int quantity) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
	}
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
