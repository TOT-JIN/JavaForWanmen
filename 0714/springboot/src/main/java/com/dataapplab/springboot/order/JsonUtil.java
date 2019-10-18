package com.dataapplab.springboot.order;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

		public static String serialize(List<CookieCartItem> item) throws JsonProcessingException{
	        ObjectMapper mapper = new ObjectMapper();
	        
	        return mapper.writeValueAsString(item);
		}
		
		@SuppressWarnings("unchecked")
		public static List<CookieCartItem> deSerialize(String value) throws IOException{
	        ObjectMapper mapper = new ObjectMapper();
			return (List<CookieCartItem>) mapper.readValue(value, List.class);
		}		
}
