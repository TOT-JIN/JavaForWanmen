package com.dataapplab.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("com.dataapplab.springboot")
public class SpringbootApplication {
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	/*help thymeleaf find message source*/
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(environment.getRequiredProperty("message.source.basename"));
		messageSource.setUseCodeAsDefaultMessage(
				Boolean.parseBoolean(environment.getRequiredProperty("message.source.use.code.as.default.message")));
		return messageSource;
	}	
}
