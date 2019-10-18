package com.dataapplab.springboot.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginCotroller {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method={RequestMethod.GET,RequestMethod.POST})
	public String oldStyleRegisterUser(HttpServletRequest request,
			@ModelAttribute Account user,RedirectAttributes redirectAttributes, Model model) {
		
		List<Account> allAccounts = userService.getAllUsers();
		if(allAccounts != null){
	        model.addAttribute("accounts", allAccounts);			
		}
		
		if(request.getMethod().equals("GET") ){		
			return "admin/pages/registerForm";
		}else if (request.getMethod().equals("POST")){
			if(user != null && user.getUserName() !=null && !user.getUserName().isEmpty()){
				System.out.println(user);
				if(allAccounts != null){
					if(allAccounts.contains(user)){
				        model.addAttribute("errorMessage", "您的用户名已经被注册");				
					}else{						
						userService.registerUser(user);
						//redirectAttributes.addAttributie("param",value);
						//return:"redirect：/path/list？param1=value1&param2=value2 "
						//redirectAttributes.addFlashAttributie("param",value);  放到session中
						redirectAttributes.addFlashAttribute("succeedMessage", "账号注册成功");						
				        return "redirect:/register";
					}					
				}
			}else{
				model.addAttribute("errorMessage", "请输入合理的内容");
			}
			return "admin/pages/registerForm";						
		}                
		return "admin/pages/registerForm";			
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm(HttpSession session,Model model) {		
		//Principal principal
		//Authentication authentication
		//HttpServletRequest 
		
	    boolean isCustomer = false;
	    boolean isAdmin = false;		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    //authentication.getAuthorities().
		    for (GrantedAuthority grantedAuthority : authentication.getAuthorities()){
		        if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
		        	isAdmin = true;
		        	//break;
		        }else if (grantedAuthority.getAuthority().equals("ROLE_CUSTOMER")) {
		        	isCustomer = true;
		        	//break;
		        }
		    }		    
		}
    	//Account user = new Account();
		//model.addAttribute("userInfo", user);
	    if (isAdmin) {
	        return "redirect:/admin/dashboard";
	    } else if (isCustomer) {
	        return "redirect:/product/";
	    } 
        return "admin/pages/login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Account user, Model model) {
         
        model.addAttribute("name", user.getUserName());
         
        return "redirect:/admin/dashboard";
    }
}
