package com.dataapplab.springboot.api;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import javax.annotation.PostConstruct;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.fasterxml.jackson.annotation.JsonView;
import com.dataapplab.springboot.product.*;

@RestController
@RequestMapping("/api")
public class OpenController {
 
	private Product iphone7;
	private Product iPadPro;
	private List<Product>  appleProducts;
	
	@PostConstruct
	public void initial(){
		iphone7 = new Product(1, "Iphone 7", new BigDecimal("5000.0"));
        iPadPro = new Product(2, "IPadPro", new BigDecimal("4000.0"));       
        appleProducts = new ArrayList<Product>(Arrays.asList(iphone7, iPadPro));
        
	}
		
	@GetMapping("/products")
    @JsonView(Product.WithoutPriceView.class)	
	public List<Product> getAllProduct(){
		return appleProducts; 
	}	
	
	@GetMapping("/products/info")
    @JsonView(Product.WithPriceView.class)	
	public List<Product> getProductView(){
		return appleProducts; 
	}
 
}