package com.dataapplab.springboot.order;

import java.io.IOException;

import com.dataapplab.springboot.product.ProductSKU;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

class OrderItemDeserializer extends StdDeserializer<OrderItem>{

    public OrderItemDeserializer() {
	        this(null);
	}

    public OrderItemDeserializer(Class<OrderItem> t) {
        super(t);
    }

    @Override
    public OrderItem deserialize(JsonParser jp, DeserializationContext dc)
                                                throws IOException, JsonProcessingException {

        int skuId = 0;
        int qty = 0;
        double price = 0.0;
        String skuNo = null;
        String skuName = null;
        JsonToken currentToken = null;
        JsonNode node = jp.getCodec().readTree(jp);
        
        skuId = (node.get("skuId")).intValue();
        qty = (node.get("qty")).intValue();
        skuName = (node.get("skuName")).textValue();
        skuNo = (node.get("skuNo")).textValue();
        price = (node.get("unitPrice")).doubleValue();

        /*while ((currentToken = jp.nextValue()) != null) {
            switch (currentToken) {
                case VALUE_NUMBER_INT:
                    switch (jp.getCurrentName()) {
	                    case "skuId":
	                    	skuId = jp.getIntValue();
	                        break;
	                    case "qty":
	                        qty = jp.getIntValue();
	                        break;
	                    case "unitPrice":
	                    	price = jp.getDoubleValue();
	                        break;	                        
	                    default:
	                        break;
                    }                    
                    break;
                case VALUE_STRING:
                	if(jp.getCurrentName().equals("skuNo")){
                		skuNo = jp.getText();
                	}
                    switch (jp.getCurrentName()) {
	                    case "skuNo":
	                    	skuNo = jp.getText();
	                        break;
	                    case "skuName":
	                    	skuName = jp.getText();
	                        break;                
	                    default:
	                        break;
                    }                    
                    break;
                default:
                    break;
            }
        }*/
        return new OrderItem(new ProductSKU(skuId,skuName,skuNo), price, qty);
    }
}