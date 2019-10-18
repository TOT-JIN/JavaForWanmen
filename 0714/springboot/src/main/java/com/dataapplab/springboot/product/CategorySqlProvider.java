package com.dataapplab.springboot.product;

import org.apache.ibatis.jdbc.SQL;

public class CategorySqlProvider {

	public String selectCategoryById() 
	{	
		return new SQL() {{
			SELECT("c.category_id, c.name as category_name");
			SELECT("product_id, p.name as product_name");
			SELECT("p.detail, image_url, price, status");
			FROM("category c");
			LEFT_OUTER_JOIN("product p on c.category_id=p.category_id");
			WHERE("c.category_id = #{id}");
		}}.toString();
	}
}
