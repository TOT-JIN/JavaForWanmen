package com.dataapplab.springboot.order;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {
	
	public String batchAddOrderItems(List<OrderItem> items) 
	{	
		return new SQL() {{
			INSERT_INTO("`order_item`");
			INSERT_INTO("(`sku_id`,`order_id`,`unit_price`,`quantity`,`create_date`,`modified_date`)");
			
			for(OrderItem item : items){
				VALUES("sku_id", "#{item.sku.id}");
				VALUES("order_id", "#{item.order.id}");
				VALUES("unit_price", "#{item.unitPrice}");
				VALUES("quantity", "#{item.quantity}");
				VALUES("create_date", "now()");
				VALUES("modified_date", "now()");
			}
		}}.toString();
	}
}
