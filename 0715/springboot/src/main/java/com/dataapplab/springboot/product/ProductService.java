package com.dataapplab.springboot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private CategoryMapper categoryDao;

    public List<Product> getProductsByCategory(int id) {
		try {
			Category category = categoryDao.getAllDescendantsProducts(id);
			List<Product> allprods = new ArrayList<Product>();
	    	for(CategoryHierarchy item :category.getDescendants()){
	        	System.out.println(item);
	        	List<Product> products = item.getProducts();
	        	if(null != products && item.getProducts().size() > 0){
	        		allprods.addAll(products);
        	}        	
	    	}
			return allprods;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}
    
    public Product getProductDetailById(int id) {
		try {
			Product ret = categoryDao.getProductDetailById(id);
			return ret;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}

}
