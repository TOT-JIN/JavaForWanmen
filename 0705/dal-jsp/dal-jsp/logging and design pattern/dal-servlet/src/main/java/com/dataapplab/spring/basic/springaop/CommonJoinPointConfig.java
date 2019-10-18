package com.dataapplab.spring.basic.springaop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.dataapplab.spring.basic.springaop.Order.*(..))")
	public void dataLayerExecution(){}
	
	@Pointcut("execution(* com.dataapplab.spring.basic.springaop.OrderService.*(..))")
	public void businessLayerExecution(){}
	
	@Pointcut("dataLayerExecution() && businessLayerExecution()")
	public void allLayerExecution(){}
	
	@Pointcut("bean(*Dao*)")
	public void beanContainingDao(){}
	
	//当前包下
	@Pointcut("within(com.dataapplab.spring.basic.springaop.Order..*)")
	public void dataLayerExecutionWithWithin(){}

	@Pointcut("@annotation(com.dataapplab.spring.basic.springaop.TrackTime)")
	public void trackTimeAnnotation(){}

}
