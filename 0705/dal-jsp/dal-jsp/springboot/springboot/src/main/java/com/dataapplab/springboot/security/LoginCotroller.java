package com.dataapplab.springboot.security;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class LoginCotroller {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm(Model model) {
		
    	Account user = new Account();
		model.addAttribute("userInfo", user);

        return "admin/pages/login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Account user, Model model) {
         
        model.addAttribute("name", user.getUserName());
         
        return "redirect:/admin/dashboard";
    }
}
