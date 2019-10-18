package com.dataapplab.springboot.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
    
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
            .antMatchers("/admin/**").authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
                        throws IOException, ServletException {
                    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    if (principal != null && principal instanceof UserDetails) {
                        UserDetails user = (UserDetails) principal;
                        
//                        System.out.println("loginUser:"+user.getUsername());

                        //维护在session中
                        request.getSession().setAttribute("userDetail", user);
                        response.sendRedirect("/");
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
            .logout()
            .permitAll()
            .and()
            .csrf().disable();  //暂时禁用CSRF，否则无法提交表单
    }

    
}