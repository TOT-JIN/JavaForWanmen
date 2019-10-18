package com.dataapplab.springboot.product;

import java.util.List;

import com.dataapplab.springboot.domain.BaseModel;

public class ProductSKU extends BaseModel {
	
	public ProductSKU(){
		
	}
	
	public ProductSKU(int id) {
		super(id);
	}
	
	public ProductSKU(int id, String name, String skuNo) {
		super(id);
		this.skuName = name;
		this.skuNo = skuNo;
	}

	private String  skuName;
	private String  skuNo;
	private Product product;
	private double  basePrice; // pricing
    private ProductStatus status;
    private List<ProductSKUValue> properties; //=> suggestPrice
    
	public String getSkuName() {
		return skuName;
	}
	public String getSkuNo() {
		return skuNo;
	}
	public Product getProduct() {
		return product;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public ProductStatus getStatus() {
		return status;
	}
	public void setSkuName(String name) {
		this.skuName = name;
	}
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}	
	
	@Override
	public String toString() {
		return "ProductSKU [name=" + skuName + ", skuNo=" + skuNo + "]";
	}
	public List<ProductSKUValue> getProperties() {
		return properties;
	}
	public void setProperties(List<ProductSKUValue> properties) {
		this.properties = properties;
	}	
}
