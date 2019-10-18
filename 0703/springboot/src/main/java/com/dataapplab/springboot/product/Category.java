package com.dataapplab.springboot.product;

import java.util.Set;


public class Category
{
	private Integer id;
	private String name;
	private String description;
	private Integer displayOrder;
	private boolean disabled;
	private Set<Product> products;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Integer getDisplayOrder()
	{
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder)
	{
		this.displayOrder = displayOrder;
	}
	
	public boolean isDisabled()
	{
		return disabled;
	}
	public void setDisabled(boolean disabled)
	{
		this.disabled = disabled;
	}
	public Set<Product> getProducts()
	{
		return products;
	}
	public void setProducts(Set<Product> products)
	{
		this.products = products;
	}
	
}