package com.dataapplab.springboot.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author joshuaz
 * 
 * @GetMapping("/owners/{ownerId}/pets/{petId}")
 * @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
 * @PostMapping(path = "/pets", consumes = "application/json")
 * 
 */

@Controller
@RequestMapping("/first/1")
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(Authentication authentication) {
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	System.out.println("User "+ userDetails.getUsername()+ " has authorities: " + userDetails.getAuthorities());    	
        return "<div style='color:red;'>Greetings!</div>";
    }
    
    @GetMapping(value="/{name}/{id}")
    public String greetingPeople(@PathVariable("name") String name,@PathVariable("id") String id, Model model) {
        return "name: "+ name + "code: "+id;
    }
}