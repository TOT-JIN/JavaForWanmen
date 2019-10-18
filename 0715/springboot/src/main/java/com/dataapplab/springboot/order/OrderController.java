package com.dataapplab.springboot.order;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1. 没有登陆，需要使用cookie来保存购物车， cookieItemsValue（json字符串）
 * 对于购物车有操作，add, remove, 减少quantity, => cookieItemsValue -> List<OrderItems>
 * add, newOrderItem + List<OrderItems> => cookieItemsValue write cookie
 * cookie name!
 * 2. 登陆后，添加到数据库Order相关表单，删除cookie, expired 过期
 * 3. 登出的时候，需要把购物车再生成为cookie, write
 * 
 * @author Administrator
 *
 */

@Controller
@RequestMapping(value="/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	private final String cookieName="ONE-PIECE";

	/**
	 * 需要的数据是 List<ProductSku> name, {variant:option}，
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/cart", method=RequestMethod.GET)
	public String displayCart (Model model) {
    	model.addAttribute("isClose", true);
		return "customer/pages/checkout";
    }    
    
    @RequestMapping(value="/cart", method=RequestMethod.POST)
   	public String addToCart ( HttpServletResponse response, @CookieValue(value = cookieName, defaultValue = "") String value,
   			@ModelAttribute OrderItem newItem,
   			Model model) throws IOException {
       	model.addAttribute("isClose", true);
       	if(value != ""){
       		List<OrderItem> result = orderService.addToShoppingCart(value, newItem);
       		if(result !=null){
       			String jsonValue = OrderService.generateOrderItemsJson(result);
       			CookieUtil.writeCookie(response, cookieName, jsonValue);
       		}
       	}
       	// model.addAtrribute
   		return "customer/pages/checkout";
       }         

    @RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String processCheckOut (Model model) {
    	model.addAttribute("isClose", true);
    	
		return "customer/pages/checkout";
    }        
	
    @RequestMapping(value="/cookie", method=RequestMethod.GET)
    @ResponseBody
	public String handleRequest (
			@CookieValue(value = "myCookieName",defaultValue = "defaultCookieValue")
            String cookieValue, Model model) {
		System.out.println(cookieValue);
		
		return "cookieValue";
    }
    
    @RequestMapping(value="/getcookie", method=RequestMethod.GET)
    @ResponseBody
    public String createCookie (HttpServletResponse response, Model model) {

        Cookie newCookie = new Cookie("testCookie", "testCookieValue");
        newCookie.setMaxAge(24 * 60 * 60);
        response.addCookie(newCookie);
        return "my-page";
    }
    
    @RequestMapping(value="/cookie", method=RequestMethod.POST)
    @ResponseBody
    public String handleRequest (HttpServletResponse response, Model model) {

        Cookie newCookie = new Cookie("testCookie", "testCookieValue");
        newCookie.setMaxAge(24 * 60 * 60);
        response.addCookie(newCookie);
        return "my-page";
    }
}
