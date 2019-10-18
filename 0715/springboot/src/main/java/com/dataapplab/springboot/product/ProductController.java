package com.dataapplab.springboot.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
    @RequestMapping(value="/category/{id}", method=RequestMethod.GET)
	public String categoryPage (@PathVariable("id")int id, Model model) {
    	model.addAttribute("isClose", true);
    	if(id > 0){
    		List<Product> allProducts= productService.getProductsByCategory(id);
        	model.addAttribute("products", allProducts);    		
    	}
    	 	
		return "customer/pages/products";
   }
    
    @RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public String productDetail (@PathVariable("id")int id, Model model) {
    	model.addAttribute("isClose", true);
    	if(id > 0){
    		Product detail = productService.getProductDetailById(id);
        	model.addAttribute("product", detail);    		
    	}    	
		return "customer/pages/detail";
   }    
}
