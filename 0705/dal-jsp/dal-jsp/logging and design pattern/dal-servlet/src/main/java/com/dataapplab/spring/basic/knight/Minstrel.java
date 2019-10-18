package com.dataapplab.spring.basic.knight;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Aspect
public class Minstrel {        
    @Before("execution(* * .embarkOnQuest(..))")
    void singBeforeQuest() {
        System.out.println("Fa la la; The knight is so brave!");
    }

    @After("execution(* * .embarkOnQuest(..))")
    public void singAfterQuest() {
        System.out.println("Tee hee he; The brave knight did embark on a quest!");
    }
}