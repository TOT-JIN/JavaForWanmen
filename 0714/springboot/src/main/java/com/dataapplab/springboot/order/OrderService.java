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
	
	public List<CookieCartItem> loadCurrentCart(){
		//customer, recover cart from storage
		return new ArrayList<CookieCartItem>();
	}
		
	public Boolean addToShoppingCart(List<OrderItem> items) {
	
		//guests, check cart cookie
		
		//if customer, save to repository

		//update cookie upon result
		try {
			int ret = orderMapper.insertOrderItems(items);
			return ret > 0;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}		
	}
	
	public Order getShoppingCart(String value) throws IOException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Order  cart = null;
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			//authenticated user
		    String currentUserName = authentication.getName();
		    //get shopping cart by account name		    
		}else{
			//guest convert from cookie
			if(value !=null){
				List<CookieCartItem>  cookieItems= JsonUtil.deSerialize(value);
				//create shopping cart info
			}			
		}		
		return cart;
	}
	
    public String generateOrderItemsJson(List<OrderItem> items) {
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
	
    public List<OrderItem> getOrderItemsFromJson(String value) throws IOException {
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
