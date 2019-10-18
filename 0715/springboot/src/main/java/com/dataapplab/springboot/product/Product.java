package com.dataapplab.springboot.product;

import java.util.List;

import com.dataapplab.springboot.domain.BaseModel;
//import com.fasterxml.jackson.annotation.JsonView;

public class Product extends BaseModel{

	public Product(){
		
	}
	
	public Product(int id, String name) {
		super();
		this.name = name;
	}
	
	private String name;
	private String detail;
	private String imageUrl; //what if we have a lot of picture for this product?

	private Category category;
	private Brand brand;
	
  //private ProductStatus status;
	private String Keywords;
	
	private List<ProductSKU> skus;
	private List<Variant> variants;

	@Override
	public String toString() {
		return "Product [id=" + this.getId() + ", name=" + name + 
				",  category=" + category + "]";
	}

	public String getName() {
		return name;
	}

    public String getDescription() {
		return detail;
	}
	
    public String getImageUrl() {
		return imageUrl;
	}
	    
	public Category getCategory() {
		return category;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.detail = description;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDetail() {
		return detail;
	}

	public String getKeywords() {
		return Keywords;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setKeywords(String keywords) {
		Keywords = keywords;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<ProductSKU> getSkus() {
		return skus;
	}

	public void setSkus(List<ProductSKU> skus) {
		this.skus = skus;
	}

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}
   
}