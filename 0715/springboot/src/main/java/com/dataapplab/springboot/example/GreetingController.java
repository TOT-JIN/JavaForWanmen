package com.dataapplab.springboot.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

	@Value("${host.name}")
	private String hostName;
	
	@GetMapping("/")
    public String sayhello(Model model) {
        model.addAttribute("name", "peer");
        return "example/greeting";
    }
    
	@RequestMapping(value = "/hello/{name}")
	@ResponseBody
	public String sayHello(@PathVariable String name,
		@RequestParam(name="how", defaultValue="Mac ") String how) {
		return "Spring "+ how + name;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm(Model model) {		
        return "example/login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String customerSubmit(@ModelAttribute User user,Model model) {    
        model.addAttribute("name", user.getName());        
        model.addAttribute("password", user.getPassword());        
        return  "example/welcome";
    }

		
	//@RequestMapping is assigned a default name based on the capital letters of the class and the full method name, GC
	@GetMapping("/say")
    public String greeting(
    		@RequestParam(name="name", required=true, defaultValue="World") String name,
    		@RequestParam(name="age",  required=false, defaultValue="20") int age,    		
    		Model model) {
        model.addAttribute("name", name);
        return "example/greeting";
    }	
}