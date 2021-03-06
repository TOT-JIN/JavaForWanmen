package com.dataapplab.spring.basic.springaop;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderDao {
	
	public List<Order> getAllOrders(){
		//fake orders
		Order order1 = new Order();
		order1.setUserName("joshua");
		order1.setSales(100.0);
		Order order2 = new Order();
		order2.setUserName("shen");
		order2.setSales(120.0);
		Order order3 = new Order();
		order2.setUserName("peize");
		order2.setSales(150.0);
		
		return Arrays.asList(order1,order2,order3);
	}
}
