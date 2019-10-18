package com.dataapplab.springboot.order;
/**
 * for cookie
 * @author joshuaz
 *
 */
public class CookieCartItem{
	public CookieCartItem(int skuId, double price, int qty) {
		super();
		this.skuId = skuId;
		this.unitPrice = price;
		this.quantity = qty;
	}
	private int skuId;
	private double unitPrice;
	private int quantity;
	
	
	public int getSkuId() {
		return skuId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public void setUnitPrice(double price) {
		this.unitPrice = price;
	}
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
}
