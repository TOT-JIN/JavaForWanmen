package com.dataapplab.springboot.product;

import java.util.List;

public class CategoryHierarchy {
    private int nodeId;
	private String name;
	private int displayOrder;
	private int length;
	private List<Product> products;
	
	@Override
	public String toString() {
		return "CategoryHierarchy [id=" + nodeId + ", name=" + name 
				+ ", length=" + length+"]";
	}
	
	public int getNodeId() {
		return nodeId;
	}
	public String getName() {
		return name;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public int getLength() {
		return length;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
