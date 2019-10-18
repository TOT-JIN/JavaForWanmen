package com.dataapplab.springboot.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import com.dataapplab.springboot.security.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void createUser(){
    	Account jane = new Account();
    	jane.setUserName("jane");
    	jane.setEmail("jane@somewhere.com");
    	jane.setPassword("123456");
    	
        int janeId= userMapper.insert(jane);

        Account user = userMapper.getUserByUserNameorEmail("jane@somewhere.com");
        assertThat(user.getUserName()).isEqualTo("jane");
    }
    
    @Test
    public void userCanBeDeleted(){
    	Account jane = new Account();
    	jane.setUserName("jane");
    	jane.setEmail("jane@somewhere.com");
    	jane.setPassword("123456");
    	
        int janeId= userMapper.insert(jane);
        int ret = userMapper.delete(janeId);

        Account user = userMapper.getUserByID(ret);
        assertThat(user).isEqualTo(null);
    }    
    
    @Test
    public void getUserInfo() {
        Account user = userMapper.getUserByID(1);
        assertThat(user.getUserName()).isEqualTo("joshua");
    }    
    
    @Test
    public void getAccounts() {
        List<Account> users = userMapper.getUsers_id();
        for(Account account :users){
            assertThat(account.getUserName()).isEqualTo("joshua");        	
        }
    }    

}
