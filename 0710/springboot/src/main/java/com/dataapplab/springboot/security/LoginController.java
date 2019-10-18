package com.dataapplab.springboot.security;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	//service
	
	@RequestMapping(value="/mylogin", method=RequestMethod.GET)
	@ResponseBody
    public List<Account> getLoginForm(Model model) {
		//logic
		return userService.getAllUsers();
    }
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	@ResponseBody
    public Account getUserProfile(Model model) {
		return userService.getUser("peize");
    }	
}
