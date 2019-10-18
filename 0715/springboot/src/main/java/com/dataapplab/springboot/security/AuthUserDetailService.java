package com.dataapplab.springboot.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class AuthUserDetailService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthUserDetailService.class);
	
    @Autowired
    private UserMapper userMapper;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            Account user = userMapper.getUserByNameorEmail(username);
            if(user != null) {
                userDetails = new AuthUserDetails(user, getAuthorities(user.getRoles()));
            } else {
                throw new UsernameNotFoundException("该用户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
	}
	
    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(Role r : roles) {
            String roleName = r.getName();
            //using permission instead of roles?
            LOGGER.info("assign role "+roleName +" to user");        
            SimpleGrantedAuthority grant = new SimpleGrantedAuthority(roleName);
            authorities.add(grant);
        }
        return authorities;
    }	
	
}