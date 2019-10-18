package com.dataapplab.spring.basic.springaop;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao dao;
	
	public int countOrders(){
		List<Order> allOrders = dao.getAllOrders();
	    System.out.println("we got "+ allOrders.size() + " orders!");
		
		return allOrders.size();
	}
	
	public double calculateTotalSales(){
		//Business Logic
		List<Order> allOrders = dao.getAllOrders();
		double asum = 0.0;
		
		for (Order item:allOrders){
			asum += item.getSales();
		}
		
		
	    //double asum = allOrders.stream().map(item -> item.getSales()).reduce(0.0, (a, b) -> a + b); 
	    
	    System.out.println("total order is "+ asum);
			
		return asum;
	}
}
