package com.dataapplab.spring.basic.dessignpattern.frontcontroller;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.dataapplab.spring.basic.dessignpattern.singleton.LazyInitializedSingleton;

public class AnnotationFrontController {
	  private static Map<String, String> contrallorMap;	  
	  private static AnnotationFrontController instance;
	    
	  private AnnotationFrontController(){
		  AnnotationFrontController.contrallorMap =  new HashMap<String, String>();
		  Reflections reflections = new Reflections("com.dataapplab.spring.basic.dessignpattern.frontcontroller");    
		  Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);
		  for(Class item : classes) {		
				System.out.println("Found Class Name : " + item.getName());
				for (Annotation annotation : item.getDeclaredAnnotations()) {
				    if( annotation.annotationType() == Dalcontroller.class){
				    	contrallorMap.put(((Dalcontroller)annotation).value(), item.getName());
						System.out.println("Loading Controller : " + item.getName());				    	
				    }
				}
		 }	  		  
	  }
	    
	  public static AnnotationFrontController getInstance(){
	        if(instance == null){
	            instance = new AnnotationFrontController();
	        }
	        return instance;
	  }	  

	  public void handleRequest(String request) {
	    Command command = getCommand(request);
	    command.process();
	  }

	  private Command getCommand(String request) {
	    Class commandClass = getCommandClass(request);
	    try {
	      return (Command) commandClass.newInstance();
	    } catch (Exception e) {
	      throw new ApplicationException(e);
	    }
	  }

	  private static Class getCommandClass(String request) {
	    Class result;
	    try {
	      result = Class.forName(contrallorMap.get(request));
	    } catch (Exception e) {
	      result = UnknownCommand.class;
	    }
	    return result;
	  }
	}
