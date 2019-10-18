package com.dataapplab.springboot.product;

import java.util.List;

import com.dataapplab.springboot.domain.BaseModel;

public class Brand extends BaseModel{
	private String name;
	private String detail;
	private String imageUrl;
	private String brandUrl;
	private List<Product> products;
	
	public String getImageUrl() {
		return imageUrl;
	}
	public String getBrandUrl() {
		return brandUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setBrandUrl(String brandUrl) {
		this.brandUrl = brandUrl;
	}
	
	public String getName() {
		return name;
	}
	public String getDetail() {
		return detail;
	}
	public String getCompanyUrl() {
		return brandUrl;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setCompanyUrl(String companyUrl) {
		this.brandUrl = companyUrl;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
