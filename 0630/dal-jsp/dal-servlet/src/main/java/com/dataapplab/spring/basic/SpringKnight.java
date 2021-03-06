package com.dataapplab.spring.basic;

import java.util.Arrays;
import com.dataapplab.spring.basic.knight.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class SpringKnight {

    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(KnightConfig.class);

        Knight knight = context.getBean(Knight.class); 
        knight.embarkOnQuest(); 
    }

}
