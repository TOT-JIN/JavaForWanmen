package com.dataapplab.spring.basic.dessignpattern.frontcontroller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;

public class TestAnnotation {
	
	public static void main(String[] args){
		Class businessLogicClass = CatapultCommand.class;

		for (Annotation annotation : businessLogicClass.getDeclaredAnnotations()) {
		    System.out.println("Annotation Name: "+ annotation.toString());
		    System.out.println("Value: "+ ((Dalcontroller)annotation).value());
		}
		
		for(Method method : businessLogicClass.getMethods()) {		
			System.out.println(" Method Name : " + method.getName());
		}
		
		Reflections reflections = new Reflections("com.dataapplab.spring.basic.dessignpattern.frontcontroller");    
		Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);
		
		for(Class item : classes) {		
			System.out.println(" Class Name : " + item.getName());
			for (Annotation annotation : item.getDeclaredAnnotations()) {				
			    System.out.println("Annotation Type: "+ annotation.annotationType());
			    if( annotation.annotationType() == Dalcontroller.class){
				    System.out.println("Con Type: "+ Dalcontroller.class);			    	
			    }
			    System.out.println("Annotation Name: "+ annotation.toString());
			    System.out.println("Value: "+ ((Dalcontroller)annotation).value());
			}
			
		}		
	}
}
