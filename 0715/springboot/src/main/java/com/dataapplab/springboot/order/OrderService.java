package com.dataapplab.springboot.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dataapplab.springboot.product.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class OrderService {
	
	@Autowired 
	private HttpSession httpsession;
	
	@Autowired
	private OrderMapper orderMapper;
	
	public OrderService(){
		
	}
	
	
	/**
	 * core concept is to merge current cart with new item
	 * first check if we already add the same item?
	 * if so, quantity add one
	 * if not add new entry
	 * @param cookieValue
	 * @param newValue
	 * @return
	 * @throws IOException
	 */
	
	public List<OrderItem> addToShoppingCart(String cookieValue, OrderItem newItem) throws IOException {
		Boolean ret= false;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try {			
			if(!(authentication instanceof AnonymousAuthenticationToken)){
				//if customer, save to repository
			    String currentUserName = authentication.getName();
				//ret = orderMapper.insertOrderItems(items);
			    //get shopping cart by account name				
			}else{
				List<OrderItem> retItems = new ArrayList<OrderItem>();
				if(cookieValue != null) {
					//gust merge cookie value with newItem
				   List<OrderItem>  items = getOrderItemsFromJson(cookieValue);
				   for(OrderItem it : items){
					   OrderItem resultItem = it.plus(newItem);
					   if(resultItem == null){
						   retItems.add(it);
					   }else{
						   retItems.add(resultItem);
					   }
				   }
				   return retItems;
			    }
				
			}	
			return null;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}		
	}
	

    public static String generateOrderItemsJson(List<OrderItem> items) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(OrderItem.class, new OrderItemSerializer());
        mapper.registerModule(module);
        String result = null;
        try {
            result = mapper.writeValueAsString(items);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
	
    public static List<OrderItem> getOrderItemsFromJson(String value) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OrderItem.class, new OrderItemDeserializer());
        mapper.registerModule(module);
        
        List<OrderItem> result = null;
        try {
        	result = mapper.readValue(value, new TypeReference<List<OrderItem>>() { });            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
