package com.dataapplab.springboot.admin;

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
@RequestMapping("/admin")
public class AdminController {
	
    @GetMapping("/dashboard")
    public String displayDashboard(Model model) {
        return "admin/pages/dashboard";
    }
    
    @GetMapping("/users")
    public String displayUsers(Model model) {
        return "admin/pages/dashboard";
    }    
   
}