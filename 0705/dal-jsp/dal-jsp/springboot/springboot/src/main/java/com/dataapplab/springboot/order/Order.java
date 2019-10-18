package com.dataapplab.springboot.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.dataapplab.springboot.security.*;

public class Order implements Serializable
{
	private Integer id;
	private String orderNumber;
	private Set<OrderItem> items;
	private Account customer;
	private Address deliveryAddress;
	private Address billingAddress;
	private Payment payment;
	private OrderStatus status;
	private Date createdOn;
	
	public Order()
	{
		this.items = new HashSet<OrderItem>();
		this.status = OrderStatus.NEW;
		this.createdOn = new Date();
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems()
	{
		return items;
	}
	public void setItems(Set<OrderItem> items)
	{
		this.items = items;
	}
	public Account getUser()
	{
		return customer;
	}
	public void setUser(Account customer)
	{
		this.customer = customer;
	}
	public Address getDeliveryAddress()
	{
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}
	public Payment getPayment()
	{
		return payment;
	}
	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}
	public OrderStatus getStatus()
	{
		return status;
	}
	public void setStatus(OrderStatus status)
	{
		this.status = status;
	}
	public Date getCreatedOn()
	{
		return createdOn;
	}
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	
	public BigDecimal getTotalAmount()
	{
		BigDecimal amount = new BigDecimal("0.0");
		for (OrderItem item : items)
		{
			amount = amount.add(item.getSubTotal());
		}
		return amount;
	}
	
}