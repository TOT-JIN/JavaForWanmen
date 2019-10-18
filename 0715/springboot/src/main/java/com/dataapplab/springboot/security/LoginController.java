package com.dataapplab.springboot.security;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @author 万门大学
 * 保护我的admin dashboard， authentication
 * /admin/dashboard ?  isAuthenticated ! 访问login
 * /admin/dashboard 可以进入
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	//service
	// 用户名是唯一的， email也是唯一的 => sql? controller? service?
	
	/**
	 * 注册后发送验证邮件？ 点击激活功能， activation user_id, "字符串" => user disable ？
	 * /activate?token="字符串"
	 * controller ： 校验字符串的合法性 user 激活
	 * @param request
	 * @param user
	 * @param redirectAttributes
	 * @param model
	 * @return
	 */
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
						//redirectAttributes.addAttributie("param1",value);
						//return:"redirect：/path/list？param1=value "
						//redirectAttributes.addFlashAttribute("param",value);  放到session中
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
	
	@RequestMapping(value="/cookie", method=RequestMethod.GET)
	@ResponseBody
    public String createCookie(HttpServletResponse response,
    		Model model) {
		//logic
        Cookie newCookie = new Cookie("testCookie", "testCookieValue");
        newCookie.setMaxAge(24 * 60 * 60);
        response.addCookie(newCookie);
        
        //check authentication cookie?
        //if , not!
        //access check authentication cookie?
        //if , not. check authorization?
        
        //save to Context Session!
        
		return "good cookie";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm(Model model) {
		//logic
        return "admin/pages/login";
    }
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	@ResponseBody
    public Account getUserProfile(Model model) {
		return userService.getUser("peize");
    }	
}
