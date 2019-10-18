package com.dataapplab.springboot.order;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dataapplab.springboot.domain.BaseModel;
import com.dataapplab.springboot.product.*;

public class OrderItem extends BaseModel
{
	
	public OrderItem(){
		
	}
	
	public OrderItem(ProductSKU productSKU, double unitPrice, int quantity) {
		super();
		this.sku = productSKU;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	private Order order;

	private ProductSKU sku;    //we may have to add more info to keep things correct
	private String  skuName;
	private double unitPrice;
	private int quantity;
	private double subTotal;
	
	public Order getOrder() {
		return order;
	}
	public ProductSKU getSku() {
		return sku;
	}
	public String getSkuName() {
		return skuName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setSku(ProductSKU sku) {
		this.sku = sku;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSubTotal(double totalPrice) {
		this.subTotal = totalPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [sku=" + sku + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
	}
	
}