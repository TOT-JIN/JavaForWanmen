package com.dataapplab.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfigurerAdapter.class);
 
	@Autowired
    private UserDetailsService userDetailsService;
	
    @Autowired
    private AuthenticationProvider securityProvider;
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.userDetailsService(userDetailsService)
        	.passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //自定义AuthenticationProvider  
        auth.authenticationProvider(securityProvider);
    }
    
    /**
     * Know what to protect
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        	.antMatchers("/resources/**", "/webjars/**","/assets/**").permitAll()
            .antMatchers("/", "/register", "/forgotPwd","/resetPwd").permitAll()
            //.antMatchers("/admin/**").authenticated()
            .antMatchers("/admin/**").hasRole("ADMIN")
            //.antMatchers("/product/**").hasRole("CUSTOMER")
            .and()
        .formLogin()
            .loginPage("/login")
            .usernameParameter("username") //SPRING_SECURITY_FORM_USERNAME_KEY                
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
                        throws IOException, ServletException {
                    LOGGER.info("Success hanlder"); //这里加入需要的处理  
                    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    if (principal != null && principal instanceof UserDetails) {
                        UserDetails user = (UserDetails) principal;   
                        LOGGER.info("loginUser:"+user.getUsername());
                        String  redirectUrl = "index"; //缺省的登陆成功页面  
                        SavedRequest savedRequest = (SavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");    
                        if(savedRequest != null) {    
                            redirectUrl =   savedRequest.getRedirectUrl();    
                            request.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
                        }
                        
                        // merge cookie orderItem with Save db                        
                        // remove cookie orderItems                   
                        
                        response.sendRedirect(redirectUrl);
                    } 
                }
            })
            //失败处理
            .failureHandler(new AuthenticationFailureHandler() {                
                @Override
                public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException)
                        throws IOException, ServletException {
                    System.out.println("error"+authenticationException.getMessage());
                    response.sendRedirect("/login");
                }
            })
            .permitAll()
            .and()
            .logout().logoutSuccessHandler(new LogoutSuccessHandler(){
				@Override
				public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					
					if(authentication != null) {
						System.out.println(authentication.getName());
				        /*Cookie cookie = new Cookie("logout","ok");
				        cookie.setPath("/");
				        cookie.setMaxAge(3600);
				        response.addCookie(cookie);*/
				    }
			        
					//perform other required operation		
					response.setStatus(HttpStatus.OK.value());
					response.sendRedirect("/index");					
					response.getWriter().flush();		
				}            	
            })
            .permitAll()
            .and()
            .csrf().disable();  //暂时禁用CSRF，否则无法提交表单
    }

    
}