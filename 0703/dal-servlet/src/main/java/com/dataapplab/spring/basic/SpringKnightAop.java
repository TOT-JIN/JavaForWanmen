package com.dataapplab.spring.basic;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import com.dataapplab.spring.basic.knight.*;

public class SpringKnightAop {

    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(KnightAopConfig.class);
        Knight knight = context.getBean(Knight.class); 
        knight.embarkOnQuest(); 
    }

}
