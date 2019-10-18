package com.dataapplab.springboot.product;

/**
 * we have to pay attention to mapper statement, especially we will configure it in xml and java annotation
 * the name should be keep consistant.
 */
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Many;

import org.apache.ibatis.annotations.Results;

@Mapper
public interface CategoryOldMapper {
    
	@Select("SELECT * FROM category_id where parent_id=#{id}")
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.CategoryResult")	
	List<CategoryOld> getChilderenByParent(int id);
			
	@Select({
        "select",
        "category_id, c.name as category_name, display_order, create_date, modified_date",
        "from category c",
        "where c.category_id = #{id,jdbcType=INTEGER}"
    })	
	
    @Results({
        @Result(column="category_id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="category_name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="display_order", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="modified_date", property="modifiedDate", jdbcType=JdbcType.DATE),
		@Result(property="children", column="parent_id",
		many=@Many(select=" com.dataapplab.springboot.product.CategoryMapper.getChilderenByParent"))
    })
	CategoryOld selectByPrimaryKey(int id);

	
	@Select("SELECT c.category_id, c.name as category_name, product_id, p.name as product_name,"
			+ "p.detail, image_url, price, status FROM category c "
			+ "left join product p on p.category_id =c.category_id")
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.CategoryResultWithProducts")	
	List<CategoryOld> getCategoryWithProducts();
	
	@SelectProvider(type=CategorySqlProvider.class, method="selectCategoryById")
	@ResultMap("com.dataapplab.springboot.product.CategoryMapper.CategoryResultWithProducts")	
	CategoryOld getCategoryWithProductsById(int id);	

}
