package com.dataapplab.spring.basic.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.dataapplab.spring.basic.dessignpattern.frontcontroller.ErrorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Configuration
public class LoggingAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@AfterThrowing(value = "@annotation(com.dataapplab.spring.basic.logging.annotation.Logging)", 
			throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
	    LOGGER.error("Aspect The method " + methodName + " occurs exception: " + ex);
	}
}
