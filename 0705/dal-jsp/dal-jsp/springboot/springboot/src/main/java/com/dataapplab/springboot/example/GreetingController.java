package com.dataapplab.springboot.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dataapplab.springboot.security.Account;

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
        model.addAttribute("prefix", hostName);
        model.addAttribute("name", "peer");
        return "example/greeting";
    }
    
	//@RequestMapping is assigned a default name based on the capital letters of the class and the full method name, GC
	@GetMapping("/{name}")
    //@ModelAttribute("messages")
    public String greeting(
    		@RequestParam(name="name", required=true, defaultValue="World") String name,
    		@RequestParam(name="age",  required=false, defaultValue="20") int age,    		
    		Model model) {
        model.addAttribute("prefix", hostName);
        model.addAttribute("name", name);
        //ModelAndView mav = new ModelAndView("message/list");
        //mav.addObject("messages", messageRepository.findAll());

        return "example/greeting";
    }
	
	@RequestMapping("/showContentPart")
	public String showContentPart() {
        return "admin/pages/dashboard::#page-wrapper";
	}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Account person) {
        // ...
    }
   
}