package com.dataapplab.springboot.notification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dataapplab.springboot.product.Category;
import com.dataapplab.springboot.product.CategoryHierarchy;
import com.dataapplab.springboot.product.CategoryMapper;

import com.dataapplab.springboot.security.UserMapper;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTests {

	@Autowired
	MailClient mailClient;
	
	@Test
	public void canSendEmail(){
		mailClient.prepareAndSend("joshua@dataapplab.com", "this is a test");
	}
}
