package com.dataapplab.springboot.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
    @Autowired
    private UserMapper userMapper;
    
	public Account createUser(Account student) {
		try {
			userMapper.insert(student);
			return student;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}
	
	public Account registerUser(Account student) {
		try {			
			userMapper.insert(student);
			return student;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}	
	
	public boolean updateUser(Account user) {
		try {
			int ret = userMapper.updateUser(user);
			return ret > 0;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}
	
	public boolean removeUser(int id) {
		try {
			int ret = userMapper.delete(id);
			return ret > 0;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}
	
    public List<Account> getAllUsers() {
    	List<Account> res = null;
        try {
            res = userMapper.getUsers_id();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }	
}
