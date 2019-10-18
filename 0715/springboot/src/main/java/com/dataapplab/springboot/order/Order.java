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







	public void setUser(Account user) {
		this.user = user;
	}



	public void setItems(List<OrderItem> items) {
		this.items = items;
	}





	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}