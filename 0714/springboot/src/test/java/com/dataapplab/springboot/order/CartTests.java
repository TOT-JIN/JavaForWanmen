package com.dataapplab.springboot.order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dataapplab.springboot.order.CookieCartItem;
import com.dataapplab.springboot.order.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;


public class CartTests {
    
	@Test
	public void canSerCartItem() throws JsonProcessingException{
		List<CookieCartItem> items = new ArrayList<CookieCartItem>();
		
		CookieCartItem item1 = new CookieCartItem(1,20,3);
		CookieCartItem item2 = new CookieCartItem(2,50,1);
		CookieCartItem item3 = new CookieCartItem(10,140,2);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		System.out.println(JsonUtil.serialize(items));
	}

	@Test
	public void canDserCartItem() throws IOException{
		List<CookieCartItem> items = new ArrayList<CookieCartItem>();
		
		CookieCartItem item1 = new CookieCartItem(1,20,3);
		CookieCartItem item2 = new CookieCartItem(2,50,1);
		CookieCartItem item3 = new CookieCartItem(10,140,2);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		String jsonValue =JsonUtil.serialize(items);
		System.out.println(JsonUtil.deSerialize(jsonValue));
	}
    
}