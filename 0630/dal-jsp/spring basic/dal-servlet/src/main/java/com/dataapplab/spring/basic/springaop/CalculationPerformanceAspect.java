package com.dataapplab.spring.basic.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CalculationPerformanceAspect {

	@Around("execution(* com.dataapplab.spring.basic.springaop.OrderService.calculateTotalSales(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object result = joinPoint.proceed(); //since we have return value calculateTotalSales

		long timeTaken = System.currentTimeMillis() - startTime;
		
		System.out.println("Time Taken by "+joinPoint+" is "+ timeTaken);
		
		return result;
	}
}
