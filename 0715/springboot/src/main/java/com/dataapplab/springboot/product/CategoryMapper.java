package com.dataapplab.springboot.product;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {

	@Insert({"INSERT INTO category_closure(category_id,name,create_date,modified_date)",
			"VALUES(#{id},#{name},#{createDate},#{modifiedDate})"})
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insertCategory(Category category);


	@Insert({"insert into category_hierarchy (ancestor, descendant, length)", 
		 "select cp.ancestor, #{newId}, cp.length+1 from category_hierarchy as cp", 
		 "where cp.descendant=#{parentId} union all select #{newId}, #{newId}, 0"})
	int insertCategoryHierarchy(int parentId, int newId);

	@Delete({"delete a ",
		"from category_hierarchy a join category_hierarchy b", 
		"on (a.descendant = b.descendant)",
		"where b.ancestor=#{newId}"})
	int deleteSubtrees(int newId);	
	
	@Select({"SELECT t.ancestor as category_id, c.category_id as node_id, c.name, t.length",
    "FROM category_closure AS c JOIN category_hierarchy AS t",
    "ON c.category_id = t.descendant",
    "WHERE t.ancestor = #{id}"})
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.CategoryResultWithDescendant")	
	Category getCategoryWithDescendants(int id);

	@Select({"SELECT t.descendant as category_id, c.category_id as node_id, c.name, t.length FROM",
	    "category_closure AS c JOIN",
	    "category_hierarchy AS t ON c.category_id = t.ancestor",
	    "WHERE t.descendant = #{id} order by length"})
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.CategoryResultWithAncestor")	
    Category getCategoryWithAncestors(int id);	
	
	@Select({
		"SELECT t.ancestor as category_id, c.category_id as node_id,", 		
		"c.name, t.length,p.product_id,p.name as product_name,p.detail,p.image_url",
		"FROM category_closure AS c", 
		"INNER JOIN category_hierarchy AS t ON c.category_id = t.descendant",
		"LEFT JOIN product as p ON c.category_id = p.category_id",
		"WHERE t.ancestor = #{id} order by length;"})
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.CategoryResultWithDescendant")	
    Category getAllDescendantsProducts(int id);
	
	
	@Select("SELECT * FROM product")
	List<Product> getProduct_id();
	
	@Select({
		"select", 
		"p.product_id, p.name as product_name, p.detail, p.image_url,", 
		"c.category_id , c.name as category_name, ",
		"sku.sku_id, sku.sku_name, sku.sku_no, sku.base_price, sku.status as sku_status,",
		"sku_value.sku_value_id,",
		"variant.variant_id, variant.name as variant_name,",
		"variant_options.variant_options_id, variant_options.value",
		"from (select * from `product` where `product`.product_id = #{id}) p", 
		"left join `category_closure` c on p.category_id = c.category_id",
		"left join `sku_value` on sku_value.product_id = p.product_id",
		"left join `sku` on sku_value.sku_id = sku.sku_id",
		"left join `variant` on sku_value.variant_id = variant.variant_id",
		"left join `variant_options` on sku_value.variant_options_id = variant_options.variant_options_id;"				
	})
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.ProductDetailResult")		
	Product getProductDetailById(int id);
}
