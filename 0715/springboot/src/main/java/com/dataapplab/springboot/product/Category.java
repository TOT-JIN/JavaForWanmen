package com.dataapplab.springboot.product;

import java.util.List;

import com.dataapplab.springboot.domain.BaseModel;


public class Category extends BaseModel
{
	private String name;
	private int displayOrder;
	private List<Product> products;	
	List<CategoryHierarchy> descendants;
	List<CategoryHierarchy> ancestors;
	
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

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public List<CategoryHierarchy> getDescendants() {
		return descendants;
	}

	public List<CategoryHierarchy> getAncestors() {
		return ancestors;
	}

	public void setDescendants(List<CategoryHierarchy> descendants) {
		this.descendants = descendants;
	}

	public void setAncestors(List<CategoryHierarchy> ancestors) {
		this.ancestors = ancestors;
	}
	
}