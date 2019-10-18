package com.dataapplab.spring.basic.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dataapplab.spring.basic.algorithm.AlgorithmConfig;
import com.dataapplab.spring.basic.logging.annotation.Logging;
import com.dataapplab.spring.basic.springaop.*;

public class SpringAopApplication{
	
	
	public static void main(String[] args) {
        ApplicationContext context = 
                new AnnotationConfigApplicationContext(LoggingConfig.class);
        
        AccessService  service= context.getBean(AccessService.class);
        
        service.tryException();
	}

}
