package com.dataapplab.spring.basic.dessignpattern.singleton;

public class ThreadSafeSingletonDouble {

    private static ThreadSafeSingletonDouble instance;
    
    private ThreadSafeSingletonDouble(){}
    
    //double checked locking principle 
    public static ThreadSafeSingletonDouble getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingletonDouble();
                }
            }
        }
        return instance;
    }
}
