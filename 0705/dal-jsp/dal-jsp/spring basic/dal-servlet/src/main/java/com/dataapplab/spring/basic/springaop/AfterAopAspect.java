package com.dataapplab.spring.basic.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {
	
	@After("execution(* com.dataapplab.spring.basic.springaop.OrderService.calculateTotalSales(..))")
	public void after(JoinPoint joinPoint) {
	    System.out.println("after execution of "+ joinPoint);		
	}
	
	@AfterReturning(value = "execution(* com.dataapplab.spring.basic.springaop.OrderService.calculateTotalSales(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
	    System.out.println(result + " afterReturning  of "+ joinPoint);		
	}
	
	@AfterThrowing(value = "execution(* com.dataapplab.spring.basic.springaop.OrderService.calculateTotalSales(..))", 
			throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
	    System.out.println(exception + "after throwing of "+ joinPoint);		
	}
	
}
