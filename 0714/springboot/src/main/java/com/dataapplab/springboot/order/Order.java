package com.dataapplab.springboot.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dataapplab.springboot.domain.BaseModel;
import com.dataapplab.springboot.security.*;

public class Order extends BaseModel implements Serializable 
{
	private Account user;
	private String orderNumber;
	private List<OrderItem> items;
	
	private PaymentMethod paymentMethod;
	private Address deliveryAddress;
	private Address billingAddress;
	private OrderStatus status;
	
	public Order()
	{
		super();
		this.items = new ArrayList<OrderItem>();
		this.status = OrderStatus.NEW;
	}
	
	public Order(int id)
	{
		super(id);
		this.items = new ArrayList<OrderItem>();
		this.status = OrderStatus.NEW;
	}
	
	public double getTotalAmount()
	{
		double amount = 0.0;
		for (OrderItem item : items)
		{
			amount += item.getSubTotal();
		}
		return amount;
	}




	public String getOrderNumber() {
		return orderNumber;
	}



	public Account getUser() {
		return user;
	}



	public List<OrderItem> getItems() {
		return items;
	}


	public Address getDeliveryAddress() {
		return deliveryAddress;
	}



	public Address getBillingAddress() {
		return billingAddress;
	}



	public OrderStatus getStatus() {
		return status;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}



	public void setUser(Account user) {
		this.user = user;
	}



	public void setItems(List<OrderItem> items) {
		this.items = items;
	}



	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}



	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}



	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}