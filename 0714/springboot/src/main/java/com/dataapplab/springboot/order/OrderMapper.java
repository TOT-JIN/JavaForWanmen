package com.dataapplab.springboot.order;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;

import com.dataapplab.springboot.security.Account;


@Mapper
public interface OrderMapper{
	
    /*int insertOrder(Order order);
    
    int selectAllMyOrders(int userId);

    int selectOrderWithItems(int id);

    int deleteOrderById(int id);
	
    int deleteOrderItemById(int id);*/

	int insertOrderItems(List<OrderItem> items);	
}