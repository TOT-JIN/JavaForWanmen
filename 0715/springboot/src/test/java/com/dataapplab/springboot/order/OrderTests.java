package com.dataapplab.springboot.order;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dataapplab.springboot.product.ProductSKU;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@MybatisTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderTests {

	//@Autowired
	private OrderService orderService;
	
	@Test
	public void equalOrderItem() throws IOException{
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		OrderItem item1 = new OrderItem(new ProductSKU(1),1500,3);
		item1.setOrder(new Order(1));
		OrderItem item3 = new OrderItem(new ProductSKU(1),3000,2);	
		item3.setOrder(new Order(1));
		
		assertThat(item1.equals(item3)).isTrue();
		
		//orderService.addToShoppingCart(items);
	}	
	
	@Test
	public void mergetTwoItem() throws IOException, CloneNotSupportedException{
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		OrderItem item1 = new OrderItem(new ProductSKU(1),1500,3);
		item1.setOrder(new Order(1));
		OrderItem item3 = new OrderItem(new ProductSKU(1),3000,2);	
		item3.setOrder(new Order(1));
		
		OrderItem newItem = item1.plus(item3);
		assertThat(newItem.getQuantity()).isEqualTo(5);
		
		//orderService.addToShoppingCart(items);
	}		
	//@Test
	public void canBatchAddItems() throws IOException{
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		OrderItem item1 = new OrderItem(new ProductSKU(1),1500,3);
		item1.setOrder(new Order(1));
		OrderItem item3 = new OrderItem(new ProductSKU(2),3000,2);	
		item3.setOrder(new Order(1));
		
		items.add(item1);
		items.add(item3);
		
		//orderService.addToShoppingCart(items);
	}	
	
	@Test
	public void canSerCartItem() throws IOException{
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		OrderItem item1 = new OrderItem(new ProductSKU(1,"hello","T1105"),120,3);
		OrderItem item2 = new OrderItem(new ProductSKU(1,"good","T2105"),50,3);
		OrderItem item3 = new OrderItem(new ProductSKU(1,"bye","T6105"),40,3);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		String jsonValue = orderService.generateOrderItemsJson(items);
		System.out.println(jsonValue);

        System.out.println("Deser=====>");

		List<OrderItem> deItems = orderService.getOrderItemsFromJson(jsonValue);
		//assertThat(deItems.get(0) instanceof OrderItem );
        assertThat(deItems.get(0)).isInstanceOf(OrderItem.class);

	      for (OrderItem item : deItems) {
	          System.out.println(item);
	       }
	}
}
