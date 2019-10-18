package com.dataapplab.springboot.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dataapplab.springboot.product.CategoryOld;
import com.dataapplab.springboot.product.CategoryOldMapper;

import com.dataapplab.springboot.security.UserMapper;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductMapperTests {
    
	@Autowired
    private CategoryOldMapper categoryOldMapper;
    
    
    @Test
    public void canGetCategoriesWithChildren(){
    	
    	CategoryOld allCats = categoryOldMapper.selectByPrimaryKey(1);
 		System.out.println(allCats);    			
    	
    	for(Category item :allCats.getChildren()){    		    		
    		System.out.println(item);
    	}
    }
    
    @Test
    public void canGetAllCategoriesWithProducts(){
    	
    	List<CategoryOld> allCats = categoryOldMapper.getCategoryWithProducts();
    	for(CategoryOld item :allCats){    		
    		System.out.println(item.getName());
     		System.out.println("having >> " + item.getProducts().size());
    		for(Product product : item.getProducts()){
    			System.out.println(product);
    		}
    	}
    }
    
    @Test
    public void canRetrieveProductUsingCategory(){
    	
    	CategoryOld beerCat = categoryOldMapper.getCategoryWithProductsById(2);
		System.out.println(beerCat.getName());
 		System.out.println(">> " + beerCat.getProducts().size());	
		for(Product product : beerCat.getProducts()){
			System.out.println(product);
		}    	
        assertThat(beerCat.getProducts().size()).isEqualTo(2);        	
    }    
    
}
