package com.dataapplab.springboot.product;

import java.util.List;
import java.util.Set;

import com.dataapplab.springboot.domain.BaseModel;


public class CategoryOld extends BaseModel
{
	private String name;
	private int displayOrder;
	private Category  parent;
	private List<Category> children;
	private List<Product> products;
	
	@Override
	public String toString() {
		return "Category [id=" + this.getId() + ", name=" + name 
				+ ", displayOrder=" + displayOrder+"]";
	}
	
	public String getName() {
		return name;
	}
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	
}