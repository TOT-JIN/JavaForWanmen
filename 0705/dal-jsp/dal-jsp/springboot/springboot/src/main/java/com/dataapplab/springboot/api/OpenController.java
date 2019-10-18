package com.dataapplab.springboot.api;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
 
import com.fasterxml.jackson.annotation.JsonView;
import com.dataapplab.springboot.product.*;
import com.dataapplab.springboot.security.Account;
import com.dataapplab.springboot.security.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/api")
public class OpenController {
 
	private Product iphone7;
	private Product iPadPro;
	private List<Product>  appleProducts;
	
	@Autowired
	private UserService userService;
	@PostConstruct
	public void initial(){
		iphone7 = new Product(1, "Iphone 7", new BigDecimal("5000.0"));
        iPadPro = new Product(2, "IPadPro", new BigDecimal("4000.0"));       
        appleProducts = new ArrayList<Product>(Arrays.asList(iphone7, iPadPro));
        
	}
	
	@GetMapping("/users")
	public List<Account> getAllUsers(){		
		return userService.getAllUsers(); 
	}	
	
	@RequestMapping(value="/users", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Account createUser(@ModelAttribute Account user){		
		return userService.createUser(user); 
	}	

	@RequestMapping(value="/users/delete", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public boolean removeUser(@ModelAttribute Account user){
		return userService.removeUser(user.getId()); 
	}	
	
	@RequestMapping(value="/users", method = RequestMethod.PUT)
	public boolean updateUser(@ModelAttribute Account user){
		System.out.println(user);
		return userService.updateUser(user); 
	}	
	
	@GetMapping("/products")
    @JsonView(ProductView.WithoutPriceView.class)	
	public List<Product> getAllProducts(){
		return appleProducts; 
	}	
	
	@GetMapping("/products/info")
    @JsonView(ProductView.WithPriceView.class)	
	public List<Product> getProductView(){
		return appleProducts; 
	}
 
}