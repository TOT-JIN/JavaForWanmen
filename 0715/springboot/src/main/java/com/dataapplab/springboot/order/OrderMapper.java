package com.dataapplab.springboot.order;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dataapplab.springboot.security.Account;


@Mapper
public interface OrderMapper{
	@Insert({"INSERT INTO `order` (`order_no`,`user_id`,`order_status`,`create_date`,`modified_date`)",
			"VALUES(#{orderNumber},#{user.user_id},#{status},now(),now())"})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insertOrder(Order order);
	
    //store? product orders,  admin, all orders?	
	@Select("select * from `order` where user_id=#{user_id};")
    List<Order> selectAllMyOrders(int user_id);
	
	@Select({
		"select u.user_id, u.user_name, o.order_id, o.order_status,", 
		"its.*, sk.*, (its.unit_price * its.quantity) as sub_total",
		"from (select user_id, user_name from `user` where user_id= #{user_id}) u",
		"left join `order` o on o.user_id = u.user_id",
		"left join `order_item` its on its.order_id = o.order_id",
		"left join `sku` sk on sk.sku_id = its.sku_id where o.order_status != 'CART';"		
	})
    Order selectMyShoppingCartItems(int user_id);

	@Select({
		"select u.user_id, u.user_name, o.order_id, o.order_status,", 
		"its.*, sk.*, (its.unit_price * its.quantity) as sub_total",
		"from (select user_id, user_name from `user` where user_id= #{userId}) u",
		"left join `order` o on o.user_id = u.user_id",
		"left join `order_item` its on its.order_id = o.order_id",
		"left join `sku` sk on sk.sku_id = its.sku_id ",
		"where o.order_status != 'CART' and o.order_id = #{orderId};"
	})
    Order selectMyOrderItemsById(int userId, int orderId);
	
    /*
    int insertOrder(Order order);
    
    int selectOrderWithItems(int id);

    int deleteOrderById(int id);
	
    int deleteOrderItemById(int id);*/
	
	int selectOrderItemBySkuId(int skuId);

	//annotation
	int insertOrderItems(List<OrderItem> items);
}