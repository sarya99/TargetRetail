package com.target.retailApp.Retail;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "product")
public class Product {
	@Id
	private String id;
	private String productId;
	private String productName;
	private CurrentPrice price;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String productId, String productName, CurrentPrice price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public CurrentPrice getPrice() {
		return price;
	}
	public void setPrice(CurrentPrice price) {
		this.price = price;
	}

	
}
