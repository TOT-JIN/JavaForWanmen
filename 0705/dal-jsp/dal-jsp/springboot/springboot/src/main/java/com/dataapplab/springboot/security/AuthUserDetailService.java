package com.dataapplab.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class AuthUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            Account user = userMapper.getUserByUserNameorEmail(username);
            if(user != null) {
                userDetails = new AuthUserDetails(user,null);
            } else {
                throw new UsernameNotFoundException("该用户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
	}
	
}