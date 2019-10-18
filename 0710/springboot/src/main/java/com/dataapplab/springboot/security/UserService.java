package com.dataapplab.springboot.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;

    public Account getUser(String userName) {
    	Account res = null;
        try {
            res = userMapper.getUserByName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }	
    
    public List<Account> getAllUsers() {
    	List<Account> res = null;
        try {
            res = userMapper.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }	
}
