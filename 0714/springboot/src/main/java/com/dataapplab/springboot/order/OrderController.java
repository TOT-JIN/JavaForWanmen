package com.dataapplab.springboot.order;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
    @RequestMapping(value="/cart", method=RequestMethod.GET)
	public String displayCart (Model model) {
    	model.addAttribute("isClose", true);
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
