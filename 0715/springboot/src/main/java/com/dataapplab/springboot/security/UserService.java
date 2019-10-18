package com.dataapplab.springboot.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public Account registerUser(Account user) {
		try {			
			//查一下合法性，是否重复，是否命名合法，password是否符合规范？
			//符合，create
			//不符合 null
			userMapper.insert(user);
			return user;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}	
	
	public Account createUser(Account user) {
		try {
			userMapper.insert(user);
			return user;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
	}
	
    public Account getUser(String userName) {
    	Account res = null;
        try {
            res = userMapper.getUserByName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
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
            res = userMapper.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }	
}
