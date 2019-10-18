package com.dataapplab.spring.basic.dessignpattern.singleton;
/**
 * 
 * @author joshuaz
 * Reference:https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class EagerInitializedSingleton {
    
	//we should avoid the instantiation until unless client calls the getInstance method
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
