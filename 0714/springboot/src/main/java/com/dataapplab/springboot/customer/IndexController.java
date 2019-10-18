package com.dataapplab.springboot.customer;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
    @GetMapping("/index")
    public String indexPage(Model model) {
    	model.addAttribute("isClose", false);
        return "customer/pages/index";
    }
}


