package com.dataapplab.springboot.product;

import java.util.List;

import com.dataapplab.springboot.domain.BaseModel;

public class Variant extends BaseModel{
	private String name;
	private List<Product> product;
	private int order;
	
	public String getName() {
		return name;
	}

	public int getOrder() {
		return order;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
