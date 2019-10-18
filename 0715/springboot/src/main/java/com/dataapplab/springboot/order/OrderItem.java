package com.dataapplab.springboot.order;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dataapplab.springboot.domain.BaseModel;
import com.dataapplab.springboot.product.*;

public class OrderItem extends BaseModel implements Cloneable
{
	
	public OrderItem(){
		
	}
	
	public OrderItem(ProductSKU productSKU, double unitPrice, int quantity) {
		super();
		this.sku = productSKU;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
    
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.getId());
		result = prime * result + ((sku == null) ? 0 : sku.getId());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!(order.getId() == other.order.getId()))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!(sku.getId() == other.sku.getId()))
			return false;
		return true;
	}

	public OrderItem plus(OrderItem other) throws CloneNotSupportedException{
        if (null == other) return null;
		
		if(this.sku.getId() == other.sku.getId() && this.order.getId() == other.order.getId()){
			OrderItem  newItem= (OrderItem) this.clone();
			newItem.setQuantity(newItem.getQuantity() + other.getQuantity());
			if(this.getModifiedDate().before(other.getModifiedDate())){
				newItem.setUnitPrice(other.getUnitPrice());				
			}
			return newItem;
		}
		return null;
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