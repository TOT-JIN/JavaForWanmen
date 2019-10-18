package com.dataapplab.springboot.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dataapplab.springboot.product.Category;
import com.dataapplab.springboot.product.CategoryHierarchy;
import com.dataapplab.springboot.product.CategoryMapper;

import com.dataapplab.springboot.security.UserMapper;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryMapperTest {
	@Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void canGetCategory(){
    	
    	Category allCats = categoryMapper.getCategoryWithDescendants(2);
    	System.out.println(allCats);
    	System.out.println(">>"+allCats.getDescendants().size());
    	for(CategoryHierarchy item :allCats.getDescendants()){
        	System.out.println(item);
    	}
    }
    
    @Test
    public void canGetCategoryAncestor(){
    	System.out.println(">>Ancestors>>");    	
    	Category allCats = categoryMapper.getCategoryWithAncestors(2);
    	System.out.println(allCats);
    	System.out.println(">>"+allCats.getAncestors().size());
    	for(CategoryHierarchy item :allCats.getAncestors()){
        	System.out.println(item);
    	}
    }
    
    @Test
    public void canGetAllProductByCategory(){
    	Category category = categoryMapper.getAllDescendantsProducts(1);

    	System.out.println(">>"+category.getDescendants().size());
    	for(CategoryHierarchy item :category.getDescendants()){
        	System.out.println(item);
        	List<Product> products = item.getProducts();
        	if(null != products){
        		System.out.println(">>"+products.size());
            	for(Product product :item.getProducts()){
            		System.out.println(">>"+product);            		
            	}        		
        	}        	
    	}
    }
}
