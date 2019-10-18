package com.dataapplab.spring.basic.dessignpattern.singleton;
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    //it will destroy the singleton pattern and both threads 
    //will get the different instances of singleton class
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}